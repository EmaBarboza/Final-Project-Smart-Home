package com.ironhack.smart_home.controller;

import com.ironhack.smart_home.model.Door;
import com.ironhack.smart_home.model.Status;
import com.ironhack.smart_home.service.DoorService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@CommonsLog
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Door createDoor(@RequestBody Door door) {
        return doorService.create(door);
    }

    @PutMapping("/{id}")
    public Door updateDoor(@PathVariable("id")UUID id, @RequestBody Door door) {
        return doorService.updateDoor(id, door);
    }

    @PatchMapping("/{id}")
    public Door updateDoorName(@PathVariable("id")UUID id, @RequestBody String name) {
        return doorService.updateDoorName(id, name);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDoor(@PathVariable("id")UUID id) {
        doorService.deleteDoor(id);
    }


}
