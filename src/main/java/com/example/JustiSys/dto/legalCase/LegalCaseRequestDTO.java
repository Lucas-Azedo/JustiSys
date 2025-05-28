package com.example.JustiSys.dto.legalCase;

import com.example.JustiSys.enums.LegalCaseStatus;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LegalCaseRequestDTO {

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotNull
    LocalDate openDate;

    @NotNull
    LegalCaseStatus status;

    @NotBlank
    private UUID clientId;
}
