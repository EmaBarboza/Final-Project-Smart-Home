package com.ironhack.smart_home.service;

import com.ironhack.smart_home.model.Location;
import com.ironhack.smart_home.model.Outlet;
import com.ironhack.smart_home.model.Status;
import com.ironhack.smart_home.repository.OutletRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OutletService {

    private final OutletRepository outletRepository;

    public List<Outlet> getAllOutlets() {
        return outletRepository.findAll();
    }

    public List<Outlet> getOutletsByStatus(Status status) {
        return outletRepository.findByStatus(status);
    }

    @Transactional
    public Outlet create(Outlet outlet) {
        log.info("Request to create a new outlet : {}", outlet);
        return outletRepository.save(outlet);
    }

    @Transactional
    public Outlet updateOutlet(Outlet outlet, UUID id) {
        log.info("Request to update an outlet : {}", outlet);
        var outletToUpdate = outletRepository.findById(id).orElseThrow();
        outletToUpdate.setStatus(outlet.getStatus());
        return outletRepository.save(outletToUpdate);
    }




    public Optional<Outlet> getOutletById(UUID id) {
        return outletRepository.findById(id);
    }



    public List<Outlet> getByLocation(Location location) {
        return outletRepository.findByLocation(location);
    }

    public List<Outlet> findByLocationAndStatus(Location location, Status status) {
        return outletRepository.findByLocationAndStatus(location, status);
    }

    public Outlet saveOutlet(Outlet outlet) {
        return outletRepository.save(outlet);
    }

    public void deleteOutlet(UUID id) {
        outletRepository.deleteById(id);
    }

    public Outlet updateOutlet(Outlet outlet) {
        return outletRepository.save(outlet);
    }


}
