package com.example.JustiSys.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    public City(){}

    public City(long id, String name){
        this.id = id;
        this.name = name;
    }
}
