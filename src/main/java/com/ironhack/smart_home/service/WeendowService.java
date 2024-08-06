package com.ironhack.smart_home.service;

import com.ironhack.smart_home.model.Location;
import com.ironhack.smart_home.model.Status;
import com.ironhack.smart_home.model.Weendow;
import com.ironhack.smart_home.repository.WeendowRepository;
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
public class WeendowService {

    private final WeendowRepository weendowRepository;

    public List<Weendow> getAllWindows() {
        return weendowRepository.findAll();
    }

    public Optional<Weendow> getWindowById(UUID id) {
        return weendowRepository.findById(id);
    }

    public List<Weendow> getWindowsByStatus(Status status) {
        return weendowRepository.findByStatus(status);
    }

    public List<Weendow> getWindowsByLocation(Location location) {
        return weendowRepository.findByLocation(location);
    }

    public List<Weendow> getWindowsByLocationAndStatus(Location location, Status status) {
        return weendowRepository.findByLocationAndStatus(location, status);
    }

    public Weendow saveWeendow(Weendow weendow) {
        return weendowRepository.save(weendow);
    }

    public void deleteWindowById(UUID id) {
        weendowRepository.deleteById(id);
    }

    public Weendow updateWindow(Weendow weendow) {
        return weendowRepository.save(weendow);
    }

    @Transactional
    public Weendow create(Weendow weendow) {
        log.info("Request to create a new window: {}" + weendow);
        return weendowRepository.save(weendow);
    }

    @Transactional
    public Weendow updateWeendow(Weendow weendow, UUID id) {
        log.info("Request to update a window: {}" + weendow);
        var weendowToUpdate = weendowRepository.findById(id).orElseThrow();
        weendowToUpdate.setStatus(weendow.getStatus());
        return weendowRepository.save(weendowToUpdate);
    }

    @Transactional
    public Weendow updateWeendowName(UUID id, String name) {
        log.info("Request to update a window: {}" + name);
        var weendowToUpdate = weendowRepository.findById(id).orElseThrow();
        weendowToUpdate.setWindowName(name);
        return weendowRepository.save(weendowToUpdate);
    }

    @Transactional
    public void  deleteWeendow(UUID id) {
        log.info("Request to delete a window: {}" + id);
        weendowRepository.deleteById(id);
    }
}
