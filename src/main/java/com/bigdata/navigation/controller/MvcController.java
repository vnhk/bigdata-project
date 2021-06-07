package com.bigdata.navigation.controller;

import com.bigdata.navigation.database.Chart;
import com.bigdata.navigation.service.NavigationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MvcController {
    private final NavigationManager navigationManager;

    @Autowired
    public MvcController(NavigationManager navigationManager) {
        this.navigationManager = navigationManager;
    }

    @GetMapping(value = "/")
    public String mainPage(Model model) {
        List<Chart> all = navigationManager.findAll();

        model.addAttribute("charts", all);
        return "index";
    }
}
