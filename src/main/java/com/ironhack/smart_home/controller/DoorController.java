package com.ironhack.smart_home.controller;

import com.ironhack.smart_home.model.Door;
import com.ironhack.smart_home.model.Status;
import com.ironhack.smart_home.service.DoorService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/door")
@RequiredArgsConstructor
public class DoorController {

    private final DoorService doorService;

    @GetMapping
    public List<Door> getAllDoors() {
        return doorService.getAllDoors();
    }

    @GetMapping ("/doors_open")
    public List<Door> getDoorsOpen() {
        return doorService.getDoorsByStatus(Status.OPEN);
    }


}