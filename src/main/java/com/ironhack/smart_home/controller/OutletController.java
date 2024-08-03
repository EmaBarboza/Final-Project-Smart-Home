package com.ironhack.smart_home.controller;

import com.ironhack.smart_home.model.Outlet;
import com.ironhack.smart_home.model.Status;
import com.ironhack.smart_home.service.OutletService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
