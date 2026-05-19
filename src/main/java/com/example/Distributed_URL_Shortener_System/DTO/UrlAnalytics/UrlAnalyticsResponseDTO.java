package com.example.Distributed_URL_Shortener_System.DTO.UrlAnalytics;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class UrlAnalyticsResponseDTO
{
    private String originalUrl;

    private String shortCode;

    private Long clickCount;
}
