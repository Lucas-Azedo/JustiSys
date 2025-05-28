package com.example.JustiSys.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityRequestDTO {
    @NotBlank
    private String name;

}
