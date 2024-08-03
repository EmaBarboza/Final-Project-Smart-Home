package com.ironhack.smart_home.repository;

import com.ironhack.smart_home.model.Location;
import com.ironhack.smart_home.model.Outlet;
import com.ironhack.smart_home.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutletRepository extends JpaRepository<Outlet, Integer> {

    List<Outlet> findByStatus(Status status);

    List<Outlet> findByLocation(Location location);

    List<Outlet> findByLocationAndStatus(Location location, Status status);

    //Find who was the last (user/manual) that turned the outlet (on/off)
}
