package com.ironhack.smart_home.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@Table(name = "outlets")
public class Outlet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int outletId;
    private String outletName;

    @Enumerated(EnumType.STRING)
    private Location location;
    private Status status;

    public Outlet(String outletName, Location location, Status status) {
        this.outletName = outletName;
        this.location = location;
        this.status = status;
    }
}
