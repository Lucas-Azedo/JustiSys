package com.example.JustiSys.dto.document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class DocumentRequestDTO {

    @NotBlank
    private String category;

    @NotBlank
    private String description;

    @NotNull
    private String fileName;

    @NotNull
    private String fileType;

    @NotNull
    private String filePath;

    @NotNull
    private UUID caseId;
}
