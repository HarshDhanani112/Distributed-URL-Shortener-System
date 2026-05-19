package com.example.Distributed_URL_Shortener_System.DTO.Login;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class LoginResponseDTO
{
    private String token;
}
