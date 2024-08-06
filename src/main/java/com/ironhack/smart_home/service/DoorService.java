package com.ironhack.smart_home.service;

import com.ironhack.smart_home.model.Door;
import com.ironhack.smart_home.model.Location;
import com.ironhack.smart_home.model.Status;
import com.ironhack.smart_home.repository.DoorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class DoorService {

    private final DoorRepository doorRepository;

    public List<Door> getAllDoors() {
        log.info("List of all doors");
        return doorRepository.findAll();
    }


    public List<Door> getDoorsByStatus(Status status) {
        log.info("List of all doors by status");
        return doorRepository.findByStatus(status);
    }

    @Transactional
    public Door create(Door door) {
        log.info("Request to create a new Door : {}", door);
        return doorRepository.save(door);
    }

    @Transactional
    public Door updateDoor(UUID id, Door door) {
        log.info("Request to update a Door : {}", door);
        var doorToUpdate = doorRepository.findById(id).orElseThrow();
        doorToUpdate.setStatus(door.getStatus());
        return doorRepository.save(doorToUpdate);
    }

    @Transactional
    public Door updateDoorName(UUID id, String name) {
        log.info("Request to update a Door by name : {}", name);
        var doorToUpdate = doorRepository.findById(id).orElseThrow();
        doorToUpdate.setDoorName(name);
        return doorRepository.save(doorToUpdate);
    }

    @Transactional
    public void deleteDoor(UUID id) {
        log.info("Request to delete a Door : {}", id);
        doorRepository.deleteById(id);
    }



    public List<Door> getDoorsByLocation(Location location) {
        return doorRepository.findByLocation(location);
    }

    public Door saveDoor(Door door) {
        return doorRepository.save(door);
    }



}
