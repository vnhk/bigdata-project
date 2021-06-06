package com.bigdata.navigation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MvcController {

    @GetMapping(value = "/")
    public String mainPage() {
        return "index";
    }
}
