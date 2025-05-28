package com.example.JustiSys.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.*;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor

@Data
@Table(name = "client")
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String email;
    private String gender;
    private String cpfOrCnpj;
    private LocalDate birthDate;

    private String phoneNumber;
    private String address;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne(optional = false)
    @JoinColumn(name = "city_id")
    private City city;

}
