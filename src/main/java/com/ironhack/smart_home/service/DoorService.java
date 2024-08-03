package com.ironhack.smart_home.service;

import com.ironhack.smart_home.model.Door;
import com.ironhack.smart_home.model.Location;
import com.ironhack.smart_home.model.Status;
import com.ironhack.smart_home.repository.DoorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class DoorService {

    private final DoorRepository doorRepository;

    public List<Door> getAllDoors() {

        return doorRepository.findAll();
    }

    public Optional<Door> getDoorById(int id) {

        return doorRepository.findById(id);
    }

    public List<Door> getDoorsByStatus(Status status) {
        return doorRepository.findByStatus(status);
    }


    public List<Door> getDoorsByLocation(Location location) {
        return doorRepository.findByLocation(location);
    }

    public Door saveDoor(Door door) {
        return doorRepository.save(door);
    }

    public void deleteDoor(int id) {
        doorRepository.deleteById(id);
    }

    public Door updateDoor(Door door) {
        return doorRepository.save(door);
    }




}
