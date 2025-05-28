package com.example.JustiSys.dto.legalCase;

import com.example.JustiSys.dto.client.ClientSummaryResponse;
import com.example.JustiSys.dto.document.DocumentSummaryResponse;
import com.example.JustiSys.enums.LegalCaseStatus;
import lombok.*;

import java.time.*;
import java.util.*;

@Data
@AllArgsConstructor
public class LegalCaseResponseDTO {

    UUID id;
    String title;
    String description;
    LegalCaseStatus status;
    LocalDate openDate;
    LocalDate closeDate;
    ClientSummaryResponse client;
    List<DocumentSummaryResponse> documents;

}
