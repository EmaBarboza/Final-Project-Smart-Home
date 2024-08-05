package com.ironhack.smart_home.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@Table(name = "doors")
public class Door {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID doorId;


    private String doorName;

    @Enumerated(EnumType.STRING)
    private Location location;
    private Status status;

    public Door(String doorName, Location location, Status status) {
        this.doorName = doorName;
        this.location = location;
        this.status = status;
    }
}
