package com.ironhack.smart_home.controller;

import com.ironhack.smart_home.model.Status;
import com.ironhack.smart_home.model.Weendow;
import com.ironhack.smart_home.service.WeendowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("window")
@RequiredArgsConstructor
public class WeendowController {

    private final WeendowService weendowService;

    @GetMapping
    public List<Weendow> getAllWindows() {
        return weendowService.getAllWindows();
    }

    @GetMapping("windows_open")
    public List<Weendow> getWindowsOpen() {
        return weendowService.getWindowsByStatus(Status.OPEN);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Weendow createWindow(@RequestBody Weendow weendow) {
        return weendowService.create(weendow);
    }
}
