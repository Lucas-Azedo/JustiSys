package com.example.JustiSys.controller;

import com.example.JustiSys.dto.ClientRequestDTO;
import com.example.JustiSys.dto.ClientResponseDTO;
import com.example.JustiSys.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<ClientResponseDTO> create(@RequestBody @Valid ClientRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.createClient(dto));
    }

    @GetMapping
    public List<ClientResponseDTO> getAll(){
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> getById (@PathVariable UUID id){
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> update(@PathVariable UUID id, @RequestBody @Valid ClientRequestDTO dto){
        return ResponseEntity.ok(clientService.updateClient(id, dto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ClientResponseDTO> delete(@PathVariable UUID id){
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }


}
