package com.example.JustiSys.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Table(name = "clients")
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String email;
    private String phoneNumber;
    private String address;

    @ManyToOne(optional = false)
    @JoinColumn(name = "city_id")
    private City city;

    public Client(){}

    public Client(String name, String email, String phoneNumber, String address, City city){
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
    }

}
