package com.example.JustiSys.dto.city;

import com.example.JustiSys.model.City;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityResponseDTO {
    private Long id;
    private String name;

    public CityResponseDTO(City city) {
        this.id = city.getId();
        this.name = city.getName();
    }
}
