package com.bigdata.navigation.controller;

import com.bigdata.navigation.database.Chart;
import com.bigdata.navigation.service.NavigationManager;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class GeneratorController {
    private final NavigationManager navigationManager;

    @Autowired
    public GeneratorController(NavigationManager navigationManager) {
        this.navigationManager = navigationManager;
    }

    @GetMapping(value = "/generate")
    public void generateData() {
        navigationManager.generateAndSend();
    }

    @PostMapping(value = "/image")
    public void addImage(@RequestBody JsonNode image) throws IOException {
        navigationManager.saveImage(image);
    }

//    @GetMapping(value = "/images")
//    public ResponseEntity<List<Chart>> getImages(@RequestBody JsonNode image) throws IOException {
//        List<Chart> all = navigationManager.findAll(image);
//
//        return new ResponseEntity<List<Chart>>(all, HttpStatus.OK);
//    }
}
