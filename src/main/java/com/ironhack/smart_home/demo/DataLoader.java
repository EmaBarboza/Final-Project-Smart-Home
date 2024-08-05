package com.ironhack.smart_home.demo;

import com.ironhack.smart_home.model.*;
import com.ironhack.smart_home.repository.DoorRepository;
import com.ironhack.smart_home.repository.OutletRepository;
import com.ironhack.smart_home.repository.WeendowRepository;
import com.ironhack.smart_home.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Slf4j
@RequiredArgsConstructor
//@Profile("load_demo_data")
public class DataLoader implements CommandLineRunner {

    private final DoorRepository doorRepository;
    private final WeendowRepository weendowRepository;
    private final OutletRepository outletRepository;
    private final UserService userService;
    private final RoleService roleService;
    private final DoorService doorService;
    private final WeendowService weendowService;
    private final OutletService outletService;

    @Override
    public void run(String... args) throws Exception {
        log.info("Loading data...");


        doorService.saveDoor(new Door("Main Door", Location.FIRST_FLOOR, Status.CLOSED));
        doorService.saveDoor(new Door("Side Door", Location.FIRST_FLOOR, Status.OPEN));
        doorService.saveDoor(new Door("Garage Door", Location.BASEMENT, Status.CLOSED));
        doorService.saveDoor(new Door("Balcony Door", Location.SECOND_FLOOR, Status.OPEN));
        doorService.saveDoor(new Door("Master Door", Location.SECOND_FLOOR, Status.CLOSED));
        doorService.saveDoor(new Door("Study lounge Door", Location.ATTIC, Status.CLOSED));
        log.info("Loading door data complete.");


        weendowService.saveWeendow(new Weendow("Window Kitchen", Location.FIRST_FLOOR, Status.OPEN));
        weendowService.saveWeendow(new Weendow("Window Master Balcony", Location.SECOND_FLOOR, Status.OPEN));
        weendowService.saveWeendow(new Weendow("Window 3", Location.SECOND_FLOOR, Status.CLOSED));
        weendowService.saveWeendow(new Weendow("Window 4", Location.SECOND_FLOOR, Status.OPEN));
        weendowService.saveWeendow(new Weendow("Window 5", Location.SECOND_FLOOR, Status.CLOSED));
        weendowService.saveWeendow(new Weendow("Window 6", Location.SECOND_FLOOR, Status.OPEN));
        weendowService.saveWeendow(new Weendow("Window 7", Location.SECOND_FLOOR, Status.CLOSED));
        weendowService.saveWeendow(new Weendow("Window 8", Location.SECOND_FLOOR, Status.OPEN));
        weendowService.saveWeendow(new Weendow("Window 9", Location.ATTIC, Status.CLOSED));
        weendowService.saveWeendow(new Weendow("Window 10", Location.ATTIC, Status.OPEN));
        log.info("Loading window data complete.");


        outletService.saveOutlet(new Outlet("Stove", Location.FIRST_FLOOR, Status.ON));
        outletService.saveOutlet(new Outlet("Fridge", Location.FIRST_FLOOR, Status.ON));
        outletService.saveOutlet(new Outlet("Outlet 1", Location.FIRST_FLOOR, Status.ON));
        outletService.saveOutlet(new Outlet("Outlet 2", Location.FIRST_FLOOR, Status.OFF));
        outletService.saveOutlet(new Outlet("Outlet 3", Location.FIRST_FLOOR, Status.ON));
        outletService.saveOutlet(new Outlet("Outlet 4", Location.SECOND_FLOOR, Status.OFF));
        outletService.saveOutlet(new Outlet("Outlet 5", Location.SECOND_FLOOR, Status.ON));
        outletService.saveOutlet(new Outlet("Outlet 6", Location.SECOND_FLOOR, Status.OFF));
        outletService.saveOutlet(new Outlet("Outlet 7", Location.OUTSIDE, Status.OFF));
        outletService.saveOutlet(new Outlet("Outlet 8", Location.OUTSIDE, Status.OFF));
        outletService.saveOutlet(new Outlet("Outlet 9", Location.BASEMENT, Status.OFF));
        outletService.saveOutlet(new Outlet("Boiler", Location.BASEMENT, Status.ON));
        outletService.saveOutlet(new Outlet("Outlet 10", Location.BASEMENT, Status.OFF));
        outletService.saveOutlet(new Outlet("Outlet 11", Location.ATTIC, Status.OFF));
        outletService.saveOutlet(new Outlet("Outlet 12", Location.ATTIC, Status.OFF));
        log.info("Loading outlet data complete.");


        roleService.save(new Role("ROLE_USER"));
        roleService.save(new Role("ROLE_ADMIN"));

        userService.saveUser(new User("John Doe", "john", "1234"));
        userService.saveUser(new User("James Smith", "james", "1234"));
        userService.saveUser(new User("Jane Carry", "jane", "1234"));
        userService.saveUser(new User("Chris Anderson", "chris", "1234"));

        roleService.addRoleToUser("john", "ROLE_USER");
        roleService.addRoleToUser("james", "ROLE_ADMIN");
        roleService.addRoleToUser("jane", "ROLE_USER");
        roleService.addRoleToUser("chris", "ROLE_ADMIN");
        roleService.addRoleToUser("chris", "ROLE_USER");




        List<Outlet> outletList = outletService.getAllOutlets();
        System.out.println("\nOutlet List: " + outletList);
        List<Outlet> outletOn = outletRepository.findByStatus(Status.ON);
        System.out.println("\n Outles in use: " + outletOn);

        List<Weendow> windowOpen = weendowRepository.findByStatus(Status.OPEN);
        System.out.println("\n Windows open: " + windowOpen);


        List<Door> doorList = doorService.getAllDoors();
        System.out.println("\n Door List: " + doorList);
        List<Door> doorOpen = doorRepository.findByStatus(Status.OPEN);
        System.out.println("\n Doors open: " + doorOpen);



    }
}


//        doorRepository.deleteAll();
//        windowRepository.deleteAll();
//        outletRepository.deleteAll();
// ------ ERASE THE ENTRIES -----------