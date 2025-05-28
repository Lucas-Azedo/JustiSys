package com.example.JustiSys.dto.legalCase;

import com.example.JustiSys.dto.client.ClientSummaryResponse;
import com.example.JustiSys.dto.document.DocumentSummaryResponse;
import com.example.JustiSys.enums.LegalCaseStatus;
import com.example.JustiSys.model.LegalCase;
import lombok.*;

import java.time.*;
import java.util.*;

@Data
@NoArgsConstructor
public class LegalCaseResponseDTO {
    UUID id;
    String title;
    String description;
    LegalCaseStatus status;
    LocalDate openDate;
    LocalDate closeDate;
    ClientSummaryResponse client;
    List<DocumentSummaryResponse> documents;

    public LegalCaseResponseDTO(LegalCase legalCase) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.openDate = openDate;
        this.closeDate = closeDate;
        this.client = client;
        this.documents = documents;
    }
}
