package com.example.JustiSys.dto.client;

import com.example.JustiSys.model.Client;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class ClientResponseDTO {
    private UUID id;
    private String name;
    private String email;
    private String cityName;

    public ClientResponseDTO(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.email = client.getEmail();
        this.cityName = client.getCity().getName();
    }
}
