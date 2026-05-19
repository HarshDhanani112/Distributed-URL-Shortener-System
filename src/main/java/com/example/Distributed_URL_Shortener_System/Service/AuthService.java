package com.example.Distributed_URL_Shortener_System.Service;


import com.example.Distributed_URL_Shortener_System.DTO.Login.LoginRequestDTO;
import com.example.Distributed_URL_Shortener_System.DTO.Login.LoginResponseDTO;
import com.example.Distributed_URL_Shortener_System.DTO.Register.RegisterRequestDTO;
import com.example.Distributed_URL_Shortener_System.DTO.Register.RegisterResponseDTO;
import com.example.Distributed_URL_Shortener_System.Model.User;
import com.example.Distributed_URL_Shortener_System.Repository.UserRepository;
import com.example.Distributed_URL_Shortener_System.Security.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthService
{
    @Autowired
    UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JWTService jwtService;

    public RegisterResponseDTO registerUser(RegisterRequestDTO requestDTO)
    {
        User user = User.builder()
                .username(requestDTO.getUsername())
                .email(requestDTO.getEmail())
                .password(passwordEncoder.encode(requestDTO.getPassword()))
                .role("USER")
                .createdAt(LocalDateTime.now())
                .build();

        User savedUser = userRepository.save(user);

        return RegisterResponseDTO.builder()
                .id(savedUser.getId())
                .username(savedUser.getUsername())
                .email(savedUser.getEmail())
                .role(savedUser.getRole())
                .build();
    }

    public LoginResponseDTO loginUser(LoginRequestDTO requestDTO)
    {
        User user = userRepository.findByEmail(requestDTO.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if(!passwordEncoder.matches(requestDTO.getPassword() , user.getPassword()))
        {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtService.generateToken(user.getEmail());

        return LoginResponseDTO.builder()
                .token(token)
                .build();
    }
}
