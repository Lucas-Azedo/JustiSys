package com.example.JustiSys.dto;

import com.example.JustiSys.model.Client;
import lombok.Data;

@Data
public class ClientResponseDTO {
    private String id;
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
