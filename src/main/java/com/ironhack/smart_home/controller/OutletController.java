package com.ironhack.smart_home.controller;

import com.ironhack.smart_home.model.Outlet;
import com.ironhack.smart_home.model.Status;
import com.ironhack.smart_home.service.OutletService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/outlet")
@RequiredArgsConstructor
public class OutletController {

    private final OutletService outletService;

    @GetMapping
    public List<Outlet> getAllOutlets() {
        return outletService.getAllOutlets();
    }

    @GetMapping("/outlets_on")
    public List<Outlet> getOutletsOn() {
        return outletService.getOutletsByStatus(Status.ON);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Outlet createOutlet(@RequestBody Outlet outlet) {
        return outletService.create(outlet);
    }

    @PutMapping("/{id}")
    public Outlet upDateOutlet(@PathVariable("id") UUID id, @RequestBody Outlet outlet) {
        return outletService.updateOutlet(outlet, id);
    }

    @PatchMapping("/{id}")
    public Outlet updateOutletName(@PathVariable("id") UUID id, @RequestBody String name) {
        return outletService.updateOutletName(id,name);
    }
}
