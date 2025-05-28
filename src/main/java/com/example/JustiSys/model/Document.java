package com.example.JustiSys.model;

import com.example.JustiSys.enums.DocumentCategory;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor

@Data
@Table(name = "document")
@Entity
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DocumentCategory category;

    private String description;

    private String fileName;
    private String fileType;
    private String filePath;

    private LocalDateTime uploadDate;
    private String uploadedBy;

    @ManyToOne(optional = false)
    @JoinColumn(name = "case_id")
    private LegalCase legalCase;
}
