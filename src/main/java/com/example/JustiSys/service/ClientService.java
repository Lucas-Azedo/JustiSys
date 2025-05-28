package com.example.JustiSys.service;

import com.example.JustiSys.dto.ClientRequestDTO;
import com.example.JustiSys.dto.ClientResponseDTO;
import com.example.JustiSys.exception.InvalidId;
import com.example.JustiSys.model.City;
import com.example.JustiSys.model.Client;
import com.example.JustiSys.repository.CityRepository;
import com.example.JustiSys.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final CityRepository cityRepository;
    private final CityService cityService;


    @Autowired
    public ClientService(ClientRepository clientRepository, CityRepository cityRepository, CityService cityService){
        this.clientRepository = clientRepository;
        this.cityRepository = cityRepository;
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

    public ClientResponseDTO getClientById(String id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(InvalidId::new);

        return new ClientResponseDTO(client);
    }

    public Client findClientEntityById(String id) {
        return clientRepository.findById(id)
                .orElseThrow(InvalidId::new);
    }

    public ClientResponseDTO updateClient(String id, ClientRequestDTO dto) {
        Client client = findClientEntityById(id);

        City city = cityService.findCityEntityById(dto.getCityId());

        client.setName(dto.getName());
        client.setEmail(dto.getEmail());
        client.setCity(city);

        Client updated = clientRepository.save(client);
        return new ClientResponseDTO(updated);
    }

    public void deleteClient(String id) {
        if (!clientRepository.existsById(id)) {
            throw new InvalidId();
        }
        clientRepository.deleteById(id);
    }




}
