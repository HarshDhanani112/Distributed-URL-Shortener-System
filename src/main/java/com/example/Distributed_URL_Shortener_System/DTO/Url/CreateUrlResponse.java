package com.example.Distributed_URL_Shortener_System.DTO.Url;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class CreateUrlResponse
{
    private String shortUrl;
}
