package com.prover.prover.utils.helpers;

import com.prover.prover.utils.Constants;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * Created by Admin on 23.05.2017.
 */
public class FileHelper {
    public static String saveUploadedFile(MultipartFile multipartFile) throws IOException {
        String fileName = UUID.randomUUID() + "_" + multipartFile.getOriginalFilename().replaceAll("[^a-zA-Z0-9.-]", "_");
        String filePath = Constants.UPLOADED_FOLDER + fileName;
        File file = new File(filePath);
        if (!file.exists()) file.createNewFile();
        byte[] bytes = multipartFile.getBytes();
        Path path = Paths.get(filePath);
        Files.write(path, bytes);
        return fileName;
    }
}
