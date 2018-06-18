package com.prover.prover.services;

import com.prover.prover.models.Images;
import com.prover.prover.models.Pattern;
import com.prover.prover.models.Stand;
import com.prover.prover.repositories.ImageRepository;
import com.prover.prover.repositories.StandRepository;
import com.prover.prover.utils.Constants;
import com.prover.prover.utils.helpers.UserHelper;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.*;
import java.util.List;

/**
 * Created by Admin on 21.05.2017.
 */
@Service
public class StandService {

    private final StandRepository standRepository;
    private final ImageRepository imageRepository;

    @Autowired
    public StandService(StandRepository standRepository, ImageRepository imageRepository) {
        this.standRepository = standRepository;
        this.imageRepository = imageRepository;
    }
    @Transactional
    public Stand getOne(Long id){
        Stand stand= standRepository.getOne(id);
        stand = (Stand) Hibernate.unproxy(stand);
        stand.setImages((Images) Hibernate.unproxy(stand.getImages()));
        return stand;
    }

    public void delete(Stand stand) {
        standRepository.delete(stand);
    }

    @Transactional
    public void update(Stand stand) {
        standRepository.save(stand);
    }

    @Transactional
    public Stand save(String text, String title) {
        Stand stand= new Stand();
        stand.setBody(text);
        stand.setTitle(title);
        List<Long> imageId = imageRepository.findAllId();
        Images images = imageRepository.getOne(imageId.get((int) (Math.random()*imageId.size())));
        images = (Images) Hibernate.unproxy(images);
        stand.setImages(images);
        stand.setUser(UserHelper.currentUser());

        return standRepository.save(stand);
    }

    public List<Stand> findByPatterns(List<Long> patternIds, Integer page) {
        return standRepository.findAllByPatternsIdIn(
                patternIds,
                PageRequest.of(page,
                        Constants.STANDS_LIMIT,
                        new Sort(Sort.Direction.ASC,
                                "patterns.id")
                )
        ).getContent();
    }

    public List<Stand> findAll(Integer page) {
        List<Stand> stands = standRepository.findAll(
                PageRequest.of(
                        page,
                        Constants.STANDS_LIMIT,
                        new Sort(Sort.Direction.ASC,
                                "patterns.id")
                )).getContent();
        for (Stand stand: stands){
           stand.setImages((Images) Hibernate.unproxy(stand.getImages()));
        }
        return stands;
    }

    public long sizeOfStands(List<Long> patternIds) {
        if ( patternIds == null || patternIds.isEmpty()){
            return standRepository.count();
        }else {
            return standRepository.countAllByPatternsIdIn(patternIds);
        }
    }

    public String runCode(String code) throws IOException {
        File javaFile = createFile(code);

        String p = javaFile.getPath();
        BufferedWriter out = new BufferedWriter(new FileWriter(javaFile));
        out.write(code);
        out.close();

        File script = createScript(code,javaFile.getPath());

        Process process = Runtime.getRuntime().exec("./"+script.getPath());
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String s ="";
        StringBuilder result = new StringBuilder();
        while ((s = reader.readLine()) != null) {
            result.append(s);
        }

        return result.toString();
    }
    private File createFile(String code) throws FileNotFoundException {
        String [] parts = code.split("\n");
        String className = "";
        for (String part : parts) {
            if (part.contains("class")) {
                className = part;
                break;
            }
        }
        String [] psvm = className.split(" ");
        for (int i = 0; i < psvm.length ; i++) {
            if (psvm[i].equals("class")) {
                className = psvm[i+1];
                break;
            }
        }
        return new File(className+".java");
    }
    private File createScript(String code, String path) throws IOException {
        File script = new File("codeRun.sh");


        Writer streamWriter = new OutputStreamWriter(new FileOutputStream(
                script));
        PrintWriter printWriter = new PrintWriter(streamWriter);

        printWriter.println("#!/bin/bash");
        printWriter.println("su coderunner");

        printWriter.println("javac "+path);
        printWriter.println("java "+path.substring(0,path.indexOf(".")));
        printWriter.close();

        return script;
    }
}
