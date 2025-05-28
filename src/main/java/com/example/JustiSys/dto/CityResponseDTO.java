package com.example.JustiSys.dto;

import com.example.JustiSys.model.City;
import lombok.Data;

@Data
public class CityResponseDTO {
    private Long id;
    private String name;

    public CityResponseDTO(City city) {
        this.id = city.getId();
        this.name = city.getName();

    }
}
