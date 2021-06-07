package com.bigdata.navigation.controller;

import com.bigdata.navigation.service.NavigationManager;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class GeneratorController {
    private final NavigationManager navigationManager;
    private final String API_KEY = "a1a0011d-2c3a-4b7c-b233-47dfb096d2bd";
    @Value("${generate-enabled}")
    private boolean generateEnabled;

    @Autowired
    public GeneratorController(NavigationManager navigationManager) {
        this.navigationManager = navigationManager;
    }

    @GetMapping(value = "/generate")
    public void generateData() throws Exception {
        if (generateEnabled) {
            navigationManager.generateAndSend();
        } else {
            throw new Exception("Generate is disabled on prod!");
        }
    }

    @PostMapping(value = "/image")
    public void addImage(@RequestBody JsonNode image) throws IOException {
        if (API_KEY.equals(image.get("API_KEY").asText())) {
            navigationManager.saveImage(image);
        }
    }
}
