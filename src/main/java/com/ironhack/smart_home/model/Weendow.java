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
//@Table(name = "windows")
public class Weendow {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID windowId;
    private String windowName;

    @Enumerated(EnumType.STRING)
    private Location location;
    private Status status;

    public Weendow(String windowName, Location location, Status status) {
        this.windowName = windowName;
        this.location = location;
        this.status = status;
    }
}
