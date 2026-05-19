package com.example.Distributed_URL_Shortener_System.Repository;

import com.example.Distributed_URL_Shortener_System.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
    Optional<User> findByEmail(String email);
}
