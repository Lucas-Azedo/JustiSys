package com.example.JustiSys.dto.client;

import com.example.JustiSys.model.Client;
import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
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
