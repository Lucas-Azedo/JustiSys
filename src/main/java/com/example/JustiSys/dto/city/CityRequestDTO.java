package com.example.JustiSys.dto.city;

import com.example.JustiSys.enums.CityState;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityRequestDTO {
    @NotBlank
    private String name;

    @NotBlank
    private CityState state;

}
