package com.example.JustiSys.service;

import com.example.JustiSys.dto.city.CityResponseDTO;
import com.example.JustiSys.dto.document.DocumentRequestDTO;
import com.example.JustiSys.dto.document.DocumentResponseDTO;
import com.example.JustiSys.enums.DocumentCategory;
import com.example.JustiSys.exception.InvalidDocumentId;
import com.example.JustiSys.model.Document;
import com.example.JustiSys.model.LegalCase;
import com.example.JustiSys.repository.DocumentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;
    private final LegalCaseService legalCaseService;

    public DocumentService(DocumentRepository documentRepository, LegalCaseService legalCaseService){
        this.documentRepository = documentRepository;
        this.legalCaseService = legalCaseService;
    }

    public DocumentResponseDTO Create(DocumentRequestDTO dto){
        LegalCase legalcase = legalCaseService.findLegalCaseEntityById(dto.getCaseId());

        Document document = new Document();

        document.setCategory(DocumentCategory.valueOf(dto.getCategory()));
        document.setDescription(dto.getDescription());
        document.setFileName(dto.getFileName());
        document.setFileType(dto.getFileType());
        document.setFilePath(dto.getFilePath());
        document.setLegalCase(legalcase);

        Document saved = documentRepository.save(document);
        return new DocumentResponseDTO(saved);
    }

    public List<DocumentResponseDTO> getAllDocuments(){
        return documentRepository.findAll()
                .stream()
                .map(DocumentResponseDTO::new)
                .collect(Collectors.toList());
    }

    public DocumentResponseDTO getDocumentById(Long id){
        Document document = documentRepository.findById(id)
                .orElseThrow(InvalidDocumentId::new);

        return new DocumentResponseDTO(document);
    }

    public Document findDocumentEntityById(Long id){
        return documentRepository.findById(id)
                .orElseThrow(InvalidDocumentId::new);
    }

    //Implement Update method here by adding a separate DTO for updating because of security

    public void deleteDocument(Long id){
        Document document = findDocumentEntityById(id);
        documentRepository.delete(document);
    }


}
