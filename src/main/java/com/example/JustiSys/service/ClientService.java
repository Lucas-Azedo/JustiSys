package com.example.JustiSys.service;

import com.example.JustiSys.dto.client.ClientRequestDTO;
import com.example.JustiSys.dto.client.ClientResponseDTO;
import com.example.JustiSys.exception.InvalidClientId;
import com.example.JustiSys.model.City;
import com.example.JustiSys.model.Client;
import com.example.JustiSys.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final CityService cityService;


    @Autowired
    public ClientService(ClientRepository clientRepository, CityService cityService){
        this.clientRepository = clientRepository;
        this.cityService = cityService;
    }

    public ClientResponseDTO createClient(ClientRequestDTO dto) {

        City city = cityService.findCityEntityById(dto.getCityId());

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

    public ClientResponseDTO getClientById(UUID id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(InvalidClientId::new);

        return new ClientResponseDTO(client);
    }

    public Client findClientEntityById(UUID id) {
        return clientRepository.findById(id)
                .orElseThrow(InvalidClientId::new);
    }

    //Fix following method by adding a separate DTO for updating because of security
    /*public ClientResponseDTO updateClient(UUID id, ClientRequestDTO dto) {
        Client client = findClientEntityById(id);

        City city = cityService.findCityEntityById(dto.getCityId());

        client.setName(dto.getName());
        client.setEmail(dto.getEmail());
        client.setCity(city);

        Client updated = clientRepository.save(client);
        return new ClientResponseDTO(updated);
    }*/

    public void deleteClient(UUID id) {
        Client client = findClientEntityById(id);
        clientRepository.delete(client);
    }
}
