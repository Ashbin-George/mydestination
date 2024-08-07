package com.example.mydestination.service;

import com.example.mydestination.dto.Userdto;
import com.example.mydestination.model.Users;
import com.example.mydestination.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Userservice {
    @Autowired
    UserRepo userRepo;

    public  String addUser(Userdto userdto) throws Exception
    {
        Users user= new Users();
        Users existingUser = userRepo.findByEmail(userdto.getUsername());
        if (existingUser != null)
        {
            throw new Exception("User already exists");
        }
        user.setEmail(userdto.getUsername());
        user.setPassword(userdto.getPassword());
        userRepo.save(user);
        return "Account Created successfully";
    }
    public Long login(Userdto userdto) throws Exception
    {
        Users user = userRepo.findByEmail(userdto.getUsername());
        if(user != null && user.getPassword().equals(userdto.getPassword()))
        {
           return user.getId();
        }
        else
        {
            throw new Exception("Invalid credentials");
        }
    }
}
