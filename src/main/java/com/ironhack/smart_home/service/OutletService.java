package com.ironhack.smart_home.service;

import com.ironhack.smart_home.model.Location;
import com.ironhack.smart_home.model.Outlet;
import com.ironhack.smart_home.model.Status;
import com.ironhack.smart_home.repository.OutletRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OutletService {

    private final OutletRepository outletRepository;

    public List<Outlet> getAllOutlets() {
        return outletRepository.findAll();
    }

    public Optional<Outlet> getOutletById(int id) {
        return outletRepository.findById(id);
    }

    public List<Outlet> getOutletsByStatus(Status status) {
        return outletRepository.findByStatus(status);
    }

    public List<Outlet> getOutletByLocation(Location location) {
        return outletRepository.findByLocation(location);
    }

    public List<Outlet> getOutletByLocationAndStatus(Location location, Status status) {
        return outletRepository.findByLocationAndStatus(location, status);
    }

    public Outlet saveOutlet(Outlet outlet) {
        return outletRepository.save(outlet);
    }

    public void deleteOutlet(int id) {
        outletRepository.deleteById(id);
    }

    public Outlet updateOutlet(Outlet outlet) {
        return outletRepository.save(outlet);
    }
}
