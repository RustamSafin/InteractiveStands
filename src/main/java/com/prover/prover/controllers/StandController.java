package com.prover.prover.controllers;

import com.prover.prover.models.Pattern;
import com.prover.prover.models.Stand;
import com.prover.prover.services.PatternService;
import com.prover.prover.services.StandService;
import com.prover.prover.utils.helpers.UserHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Admin on 21.05.2017.
 */
@Controller
@RequestMapping("/")
public class StandController {

    private final StandService standService;
    private final PatternService patternService;
    @RequestMapping(value = "/test")
    public String testhuesr(){
        Stand stand=new Stand();
        stand.setTitle("govno");
        stand.setBody("ZHopa");
        return "toolbar";
    }

    @RequestMapping()
    public String testhur(){
        return "template";
    }

    @Autowired
    public StandController(StandService standService, PatternService patternService) {
        this.standService = standService;
        this.patternService = patternService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Stand> viewAll(@RequestParam(required = false, name = "patterns[]") List<Long> patternIds,
                               @RequestParam(required = false, defaultValue = "1") Integer page) {
        List<Stand> stands;
        if (patternIds != null && !patternIds.isEmpty()) {
            stands = standService.findByPatterns(patternIds, page - 1);
        } else {
            stands = standService.findAll(page - 1);
        }

        return stands;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createStand(@RequestParam String text,
                              @RequestParam String title,
                              @RequestParam(name = "patterns[]") List<Long> pattenIds,
                              Model model) {
        List<Pattern> patterns = patternService.getByIds(pattenIds);
        Stand stand = standService.save(text, title, patterns);
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

}
