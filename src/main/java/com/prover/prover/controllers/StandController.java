package com.prover.prover.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prover.prover.models.Images;
import com.prover.prover.models.Pattern;
import com.prover.prover.models.Stand;
import com.prover.prover.services.ImageService;
import com.prover.prover.services.PatternService;
import com.prover.prover.services.StandService;
import com.prover.prover.utils.helpers.FileHelper;
import com.prover.prover.utils.helpers.UserHelper;
import com.prover.prover.wrappers.StandListWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created by Admin on 21.05.2017.
 */
@Controller
@RequestMapping("/")
public class StandController {

    private final StandService standService;
    private final PatternService patternService;
    private final ImageService imageService;

    @RequestMapping(value = "/test")
    public String testhuesr() {
        Stand stand = new Stand();
        stand.setTitle("govno");
        stand.setBody("ZHopa");
        return "toolbar";
    }

    @RequestMapping()
    public String testhur(Authentication authentication) {
        return "template";
    }

    @RequestMapping("/content")
    public String testhus() {
        return "content";
    }

    @Autowired
    public StandController(StandService standService, PatternService patternService, ImageService imageService) {
        this.standService = standService;
        this.patternService = patternService;
        this.imageService = imageService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/stands")
    @ResponseBody
    public StandListWrapper viewAll(@RequestParam(required = false, name = "patterns[]") List<Long> patternIds,
                                    @RequestParam(required = false, defaultValue = "1") Integer page) {
        List<Stand> stands;

        if (patternIds != null && !patternIds.isEmpty()) {
            stands = standService.findByPatterns(patternIds, page - 1);
        } else {
            stands = standService.findAll(page - 1);
        }

        StandListWrapper standListWrapper =new StandListWrapper();
        standListWrapper.setStandList(stands);
        standListWrapper.setSize(standService.sizeOfStands(patternIds));

        return standListWrapper;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> upload(@RequestParam(name = "file") MultipartFile uploadFile) {
        System.out.println(uploadFile.getContentType());
        if (uploadFile.isEmpty()) {
            return new ResponseEntity<>("file is empty!", HttpStatus.BAD_REQUEST);
        }
        if (!uploadFile.getContentType().equals(MimeTypeUtils.IMAGE_GIF_VALUE) ||
                !uploadFile.getContentType().equals(MimeTypeUtils.IMAGE_JPEG_VALUE) ||
                !uploadFile.getContentType().equals(MimeTypeUtils.IMAGE_PNG_VALUE)) {
            return new ResponseEntity<>("invalidType", HttpStatus.BAD_REQUEST);
        }
        Images images = null;
        try {

            String fileName = FileHelper.saveUploadedFile(uploadFile);
            images = imageService.saveImage(fileName);

        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(images, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createStand(@RequestParam String text,
                              @RequestParam String title,
                              @RequestParam(name = "patterns[]") List<Long> pattenIds,
                              @RequestParam Long imageId,
                              Model model) {
        List<Pattern> patterns = patternService.getByIds(pattenIds);
        Stand stand = standService.save(text, title, patterns, imageId);
        model.addAttribute("stand", stand);
        return "";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createStand() {
        return "createLesson";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String viewStand(@PathVariable Long id, Model model) {
        model.addAttribute("stand", standService.getOne(id));

        return "";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public String deleteStand(@PathVariable Long id, Model model) {
        Stand stand = standService.getOne(id);
        if (stand != null && UserHelper.currentUser().equals(stand.getUser())) {
            standService.delete(stand);
        }
        return "";
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String patchStand(@PathVariable Long id,
                             @RequestParam String text,
                             @RequestParam String title,
                             @RequestParam(name = "patterns[]") List<Long> pattenIds,
                             Model model) {
        Stand stand = standService.getOne(id);
        List<Pattern> patterns = patternService.getByIds(pattenIds);
        if (stand != null && UserHelper.currentUser().equals(stand.getUser())) {
            stand.setBody(text);
            stand.setTitle(title);
            stand.getPatterns().clear();
            stand.getPatterns().addAll(patterns);
            standService.update(stand);
        }
        return "";
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    @ResponseBody
    public Stand viewBeforeUpdateStand(@PathVariable Long id, Model model) {
        Stand stand = standService.getOne(id);

        model.addAttribute("stand", stand);
        return stand;
    }

    @RequestMapping(value = "/canManageStand/{id}", method = RequestMethod.GET)
    @ResponseBody
    public boolean canManageStand(@PathVariable Long id){
        Stand stand = standService.getOne(id);
        return stand.getUser().equals(UserHelper.currentUser());
    }
}
