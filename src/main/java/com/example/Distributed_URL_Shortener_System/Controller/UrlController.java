package com.example.Distributed_URL_Shortener_System.Controller;

import com.example.Distributed_URL_Shortener_System.DTO.Url.CreateUrlRequest;
import com.example.Distributed_URL_Shortener_System.DTO.Url.CreateUrlResponse;
import com.example.Distributed_URL_Shortener_System.DTO.UrlAnalytics.UrlAnalyticsResponseDTO;
import com.example.Distributed_URL_Shortener_System.Service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/url")
public class UrlController
{
    @Autowired
    private UrlService urlService;

    @PostMapping("/create")
    public CreateUrlResponse createShortUrl(@RequestBody CreateUrlRequest request)
    {
        return urlService.createShortUrl(request);
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirect(@PathVariable String shortCode)
    {
        String originalUrl = urlService.getOriginalUrl(shortCode);

        HttpHeaders headers = new HttpHeaders();

        headers.setLocation(URI.create(originalUrl));

        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }

    @GetMapping("/analytics/{shortCode}")
    public UrlAnalyticsResponseDTO getAnalytics(@PathVariable String shortCode)
    {
        return urlService.getAnalytics(shortCode);
    }
}
