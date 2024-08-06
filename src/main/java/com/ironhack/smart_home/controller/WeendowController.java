package com.ironhack.smart_home.controller;

import com.ironhack.smart_home.model.Status;
import com.ironhack.smart_home.model.Weendow;
import com.ironhack.smart_home.service.WeendowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @PutMapping("/{id}")
    public Weendow updateWindow(@PathVariable("id") UUID id, @RequestBody Weendow weendow) {
        return weendowService.updateWeendow(weendow, id);
    }

    @PatchMapping("/{id}")
    public Weendow updateWeendow(@PathVariable("id") UUID id, @RequestBody String name) {
        return weendowService.updateWeendowName(id, name);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWindow(@PathVariable("id") UUID id) {
        weendowService.deleteWeendow(id);
    }
}
