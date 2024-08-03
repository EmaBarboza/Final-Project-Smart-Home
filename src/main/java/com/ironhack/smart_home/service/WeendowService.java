package com.ironhack.smart_home.service;

import com.ironhack.smart_home.model.Location;
import com.ironhack.smart_home.model.Status;
import com.ironhack.smart_home.model.Weendow;
import com.ironhack.smart_home.repository.WeendowRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class WeendowService {

    private final WeendowRepository weendowRepository;

    public List<Weendow> getAllWindows() {
        return weendowRepository.findAll();
    }

    public Optional<Weendow> getWindowById(int id) {
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

    public void deleteWindowById(int id) {
        weendowRepository.deleteById(id);
    }

    public Weendow updateWindow(Weendow weendow) {
        return weendowRepository.save(weendow);
    }


}
