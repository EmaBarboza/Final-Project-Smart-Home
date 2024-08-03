package com.ironhack.smart_home.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/energy")
@RequiredArgsConstructor
public class EnergyController {

    @GetMapping(value = "/consumption", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Double> consumption() {
        System.out.println("Energy Consumption");
        return ResponseEntity.ok(1.0);
    }

    @GetMapping(value = "/production", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Double> production() {
        System.out.println("Energy Production");
        return ResponseEntity.ok(2.0);
    }
}
