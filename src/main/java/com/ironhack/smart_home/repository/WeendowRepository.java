package com.ironhack.smart_home.repository;

import com.ironhack.smart_home.model.Location;
import com.ironhack.smart_home.model.Status;
import com.ironhack.smart_home.model.Weendow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeendowRepository extends JpaRepository<Weendow, Integer> {

    List<Weendow> findByLocation(Location location);

    List<Weendow> findByStatus(Status Status);

    List<Weendow> findByLocationAndStatus(Location location, Status Status);

    //Find who was the last (user/manual) that opened/closed the window
}
