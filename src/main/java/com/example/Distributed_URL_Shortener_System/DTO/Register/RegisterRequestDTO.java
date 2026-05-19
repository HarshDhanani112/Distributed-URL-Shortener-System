package com.example.Distributed_URL_Shortener_System.DTO.Register;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class RegisterRequestDTO
{
    private String username;

    private String email;

    private String password;
}
