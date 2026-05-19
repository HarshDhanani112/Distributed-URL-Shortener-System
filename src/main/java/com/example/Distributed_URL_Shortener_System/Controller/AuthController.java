package com.example.Distributed_URL_Shortener_System.Controller;

import com.example.Distributed_URL_Shortener_System.DTO.Login.LoginRequestDTO;
import com.example.Distributed_URL_Shortener_System.DTO.Login.LoginResponseDTO;
import com.example.Distributed_URL_Shortener_System.DTO.Register.RegisterRequestDTO;
import com.example.Distributed_URL_Shortener_System.DTO.Register.RegisterResponseDTO;
import com.example.Distributed_URL_Shortener_System.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController
{
    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public RegisterResponseDTO registerUser(@RequestBody RegisterRequestDTO requestDTO)
    {
        return authService.registerUser(requestDTO);
    }

    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody LoginRequestDTO requestDTO)
    {
        return authService.loginUser(requestDTO);
    }
}
