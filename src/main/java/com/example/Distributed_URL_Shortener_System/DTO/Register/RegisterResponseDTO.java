package com.example.Distributed_URL_Shortener_System.DTO.Register;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class RegisterResponseDTO
{
    private Long id;

    private String username;

    private String email;

    private String role;
}
