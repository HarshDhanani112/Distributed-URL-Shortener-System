package com.example.Distributed_URL_Shortener_System.Service;

import com.example.Distributed_URL_Shortener_System.DTO.Url.CreateUrlRequest;
import com.example.Distributed_URL_Shortener_System.DTO.Url.CreateUrlResponse;
import com.example.Distributed_URL_Shortener_System.DTO.UrlAnalytics.UrlAnalyticsResponseDTO;
import com.example.Distributed_URL_Shortener_System.Model.Url;
import com.example.Distributed_URL_Shortener_System.Model.User;
import com.example.Distributed_URL_Shortener_System.Repository.UrlRepository;
import com.example.Distributed_URL_Shortener_System.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UrlService
{
    @Autowired
    private UrlRepository urlRepository;

    @Autowired
    private UserRepository userRepository;

    public CreateUrlResponse createShortUrl(CreateUrlRequest request)
    {
        String email = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        String shortCode = UUID.randomUUID()
                .toString()
                .substring(0, 6);

        Url url = Url.builder()
                .originalUrl(request.getOriginalUrl())
                .shortCode(shortCode)
                .createdAt(LocalDateTime.now())
                .clickCount(0L)
                .user(user)
                .build();

        urlRepository.save(url);

        return CreateUrlResponse.builder()
            .shortUrl("http://localhost:8080/" + shortCode)
            .build();
    }

    public String getOriginalUrl(String shortCode)
    {
        Url url = urlRepository.findByShortCode(shortCode)
                .orElseThrow(() -> new RuntimeException("URL not found"));

        if(url.getClickCount() == null)
        {
            url.setClickCount(0L);
        }

        url.setClickCount(url.getClickCount() + 1);

        urlRepository.save(url);

        return url.getOriginalUrl();
    }

    public UrlAnalyticsResponseDTO getAnalytics(String shortCode)
    {
        Url url = urlRepository.findByShortCode(shortCode)
                .orElseThrow(() -> new RuntimeException("URL not found"));

        return UrlAnalyticsResponseDTO.builder()
                .originalUrl(url.getOriginalUrl())
                .shortCode(url.getShortCode())
                .clickCount(url.getClickCount())
                .build();
    }
}
