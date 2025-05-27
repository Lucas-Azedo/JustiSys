package com.example.JustiSys.service;

import com.example.JustiSys.dto.ClientRequestDTO;
import com.example.JustiSys.dto.ClientResponseDTO;
import com.example.JustiSys.model.City;
import com.example.JustiSys.model.Client;
import com.example.JustiSys.repository.CityRepository;
import com.example.JustiSys.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class ClientService {

    private final ClientRepository clientRepository;
    private final CityRepository cityRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository, CityRepository cityRepository){
        this.clientRepository = clientRepository;
        this.cityRepository = cityRepository;
    }

    public ClientResponseDTO CreateClient(ClientRequestDTO dto) {

        City city = cityService.getCityById(dto.getCityId());

        Client client = new Client();
        client.setName(dto.getName());
        client.setEmail(dto.getEmail());
        client.setCity(city);

        Client saved = clientRepository.save(client);
        return new ClientResponseDTO(saved);
    }

    public List<ClientResponseDTO > getAllClients(){
        return clientRepository.findAll()
                .stream()
                .map(ClientResponseDTO::new)
                .collect(Collectors.toList());
    }

    public ClientResponseDTO  getClientById(String id){
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente nao encontrado"));

        return new ClientResponseDTO(client);
    }
}
