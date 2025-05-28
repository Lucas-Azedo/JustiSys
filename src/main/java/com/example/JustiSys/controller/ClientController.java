package com.example.JustiSys.controller;

import com.example.JustiSys.dto.ClientRequestDTO;
import com.example.JustiSys.dto.ClientResponseDTO;
import com.example.JustiSys.service.ClientService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<ClientResponseDTO> getById (@PathVariable String id){
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @PutMapping
    public ResponseEntity<ClientResponseDTO> update(@PathVariable String id, @RequestBody @Valid ClientRequestDTO dto){
        return ResponseEntity.ok(clientService.updateClient(id, dto));
    }

    @DeleteMapping("{id")
    public ResponseEntity<ClientResponseDTO> delete(@PathVariable String id){
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }


}
