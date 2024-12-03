package com.example.mydestination.controller;


import com.example.mydestination.constants.ApiRoutes;
import com.example.mydestination.dto.Userdto;
import com.example.mydestination.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping(ApiRoutes.createuser)
@RestController
public class UserController
{
    @Autowired
    Userservice userservice;

    @PostMapping("/add-user")
    public ResponseEntity<?> adduser(@RequestBody Userdto user)
    {
        try
        {
         String result= userservice.addUser(user);
         return ResponseEntity.ok().body(result);
        }
        catch (Exception ex)
        {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Failed to add user");
        }
    }
    @GetMapping("/login-user")
    public ResponseEntity<?> loginuser(@RequestBody Userdto user)
    {
        try
        {
            Long result=userservice.login(user);
            return ResponseEntity.ok().body(result);
        }
        catch (Exception ex)
        {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("failed to login");
        }
    }
    @DeleteMapping("/delete-user")
    public ResponseEntity<?>deleteuser(@RequestBody Userdto user)
    {
        try
        {
            String result= userservice.deleteuser(username);
        }
    }
}
