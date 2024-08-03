package com.ironhack.smart_home.repository;

import com.ironhack.smart_home.model.Door;
import com.ironhack.smart_home.model.Location;
import com.ironhack.smart_home.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoorRepository extends JpaRepository<Door, Integer> {

    List<Door> findByStatus(Status status);

    List<Door> findByLocation(Location location);




    //List<Door> findByLocationAndDoorStatus(String location, String status);

    //Find who was the last (user/manual) that opened/closed the door


}
