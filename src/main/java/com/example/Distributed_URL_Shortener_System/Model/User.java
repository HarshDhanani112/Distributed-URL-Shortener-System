package com.example.Distributed_URL_Shortener_System.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "users")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String username;

    @Column(unique = true , nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String role;

    private LocalDateTime createdAt;
}
