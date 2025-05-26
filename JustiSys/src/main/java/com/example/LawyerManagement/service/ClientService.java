package com.example.LawyerManagement.service;

import com.example.LawyerManagement.model.City;
import com.example.LawyerManagement.model.Client;
import com.example.LawyerManagement.repository.CityRepository;
import com.example.LawyerManagement.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientService {

    private final ClientRepository clientRepository;
    private final CityRepository cityRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository, CityRepository cityRepository){
        this.clientRepository = clientRepository;
        this.cityRepository = cityRepository;
    }

    public Client CreateClient(Client client, Long cityId){

        City city = cityRepository.findById(cityId)
                        .orElseThrow(() -> new RuntimeException("Cidade nao encontrada"));

        client.setCity(city);
        return clientRepository.save(client);
    }
}
