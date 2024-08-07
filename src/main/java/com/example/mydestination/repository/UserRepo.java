package com.example.mydestination.repository;


import com.example.mydestination.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users,Long>
{
    Users findByEmail(String email);
}
