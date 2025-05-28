package com.example.JustiSys.dto.client;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
public class ClientRequestDTO {
    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String cpfOrCnpj;

    @NotNull
    private Long cityId;
}
