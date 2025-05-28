package com.example.JustiSys.dto.document;

import com.example.JustiSys.dto.legalCase.LegalCaseSummaryResponse;
import lombok.*;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
public class DocumentResponseDTO {

     Long id;

     String category;
     String description;
     String fileName;
     String fileType;
     String filePath;
     LocalDateTime uploadDate;
     String uploadedBy;
     LegalCaseSummaryResponse legalCase;
}
