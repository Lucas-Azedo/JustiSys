package com.example.JustiSys.dto.document;

import com.example.JustiSys.dto.legalCase.LegalCaseSummaryResponse;
import com.example.JustiSys.model.Document;
import lombok.*;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
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

     public DocumentResponseDTO(Document document) {
          this.id = id;
          this.category = category;
          this.description = description;
          this.fileName = fileName;
          this.fileType = fileType;
          this.filePath = filePath;
          this.uploadDate = uploadDate;
          this.uploadedBy = uploadedBy;
          this.legalCase = legalCase;
     }
}
