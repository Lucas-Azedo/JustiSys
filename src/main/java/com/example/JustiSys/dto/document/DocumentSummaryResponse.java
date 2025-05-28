package com.example.JustiSys.dto.document;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DocumentSummaryResponse {
    Long id;
    String name;
    String type;
    LocalDateTime uploadedA;
}
