package com.example.JustiSys.service;

import com.example.JustiSys.dto.legalCase.LegalCaseRequestDTO;
import com.example.JustiSys.dto.legalCase.LegalCaseResponseDTO;
import com.example.JustiSys.exception.InvalidLegalCaseId;
import com.example.JustiSys.model.Client;
import com.example.JustiSys.model.LegalCase;
import com.example.JustiSys.repository.LegalCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class LegalCaseService {
    private final LegalCaseRepository legalCaseRepository;
    private final ClientService clientService;

    @Autowired
    public LegalCaseService(LegalCaseRepository legalCaseRepository, ClientService clientService) {
        this.legalCaseRepository = legalCaseRepository;
        this.clientService = clientService;
    }

    public LegalCaseResponseDTO createLegalCase(LegalCaseRequestDTO dto) {
        Client client = clientService.findClientEntityById(dto.getClientId());

        LegalCase legalCase = new LegalCase();
        legalCase.setTitle(dto.getTitle());
        legalCase.setDescription(dto.getDescription());
        legalCase.setStatus(dto.getStatus());
        legalCase.setCreatedAt(LocalDateTime.now());
        legalCase.setClient(client);

        LegalCase saved = legalCaseRepository.save(legalCase);
        return new LegalCaseResponseDTO(saved);
    }

    public List<LegalCaseResponseDTO> getAllLegalCases() {
        return legalCaseRepository.findAll()
                .stream()
                .map(LegalCaseResponseDTO::new)
                .collect(Collectors.toList());
    }

    public LegalCaseResponseDTO getLegalCaseById(UUID id) {
        LegalCase legalCase = legalCaseRepository.findById(id)
                .orElseThrow(InvalidLegalCaseId::new);

        return new LegalCaseResponseDTO(legalCase);
    }

    public LegalCase findLegalCaseEntityById(UUID id) {
        return legalCaseRepository.findById(id)
                .orElseThrow(InvalidLegalCaseId::new);
    }

    //Implement Update method here by adding a separate DTO for updating because of security

    public void DeleteLegalCase(UUID id) {
        LegalCase legalCase = findLegalCaseEntityById(id);
        legalCaseRepository.delete(legalCase);
    }
}
