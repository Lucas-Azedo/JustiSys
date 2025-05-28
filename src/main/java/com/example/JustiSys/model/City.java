package com.example.JustiSys.model;

import com.example.JustiSys.enums.CityState;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor

@Data
@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private CityState state;
}
