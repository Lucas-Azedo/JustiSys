package com.example.JustiSys.model;

import com.example.JustiSys.enums.LegalCaseStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.*;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor

@Data
@Table(name = "legalCase")
@Entity
public class LegalCase {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private LegalCaseStatus status;

    private String title;
    private String caseNumber;
    private String courtName;
    private String description;

    private LocalDate openDate;
    private LocalDate closingDate;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "legalCase", cascade = CascadeType.ALL)
    private List<Document> documents = new ArrayList<>();
}

