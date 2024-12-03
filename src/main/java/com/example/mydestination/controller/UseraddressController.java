package com.example.mydestination.controller;


import com.example.mydestination.constants.ApiRoutes;
import com.example.mydestination.dto.Useraddressdto;
import com.example.mydestination.service.UseraddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(ApiRoutes.useraddress)
@RestController
public class UseraddressController {
    @Autowired
    UseraddressService useraddressService;
    @PostMapping("/adduseraddress")
    public ResponseEntity<?>  adduseraddress(@RequestBody Useraddressdto useraddressdto)
    {
        try
        {
            String result= useraddressService.adduseraddress(useraddressdto);
            return ResponseEntity.ok().body(result);
        }
        catch (Exception ex)
        {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("failed to add user address");
        }
    }
    @PutMapping("/edituseraddress")
    public  ResponseEntity<?> edituseraddress(@RequestBody Useraddressdto useraddressdto)
    {
        try
        {
            String result = useraddressService.edituseraddress(useraddressdto);
            return ResponseEntity.ok().body(result);
        }
        catch (Exception ex)
        {
            return  ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Failed to update user");
        }
    }
}
