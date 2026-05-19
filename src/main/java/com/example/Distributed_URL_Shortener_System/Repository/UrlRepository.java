package com.example.Distributed_URL_Shortener_System.Repository;

import com.example.Distributed_URL_Shortener_System.Model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long>
{
    Optional<Url> findByShortCode(String shortCode);
}
