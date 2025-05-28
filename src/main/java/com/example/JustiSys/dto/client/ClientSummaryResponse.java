package com.example.JustiSys.dto.client;

import lombok.*;
import java.util.*;

@Data
public class ClientSummaryResponse {
    UUID id;
    String name;
    String cpf;
    String phone;
}
