package com.example.Distributed_URL_Shortener_System.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "urls")
public class Url
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 5000)
    private String originalUrl;

    @Column(nullable = false, unique = true)
    private String shortCode;

    private LocalDateTime createdAt;

    private Long clickCount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
