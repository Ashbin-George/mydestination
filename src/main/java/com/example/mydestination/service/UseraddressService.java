package com.example.mydestination.service;

import com.example.mydestination.dto.Useraddressdto;
import com.example.mydestination.model.Useraddress;
import com.example.mydestination.model.Users;
import com.example.mydestination.repository.ProductsRepo;
import com.example.mydestination.repository.UserRepo;
import com.example.mydestination.repository.UseraddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

@Service
public class UseraddressService {
    @Autowired
    UseraddressRepo useraddressRepo;

    @Autowired
    UserRepo userRepo;

    public String adduseraddress(Useraddressdto useraddressdto)
    {
        Users user = userRepo.findById(useraddressdto.getUserId()).orElseThrow(() -> new RuntimeException("Invalid user"));
        Useraddress useraddress=new Useraddress();
        useraddress.setHousename(useraddressdto.getHousename());
        useraddress.setLocality(useraddressdto.getLocality());
        useraddress.setDistrict(useraddressdto.getDistrict());
        useraddress.setState(useraddressdto.getState());
        useraddress.setCountry(useraddressdto.getCountry());
        useraddress.setPincode(useraddressdto.getPincode());
        useraddress.setPhno(useraddressdto.getPhno());
        useraddress.setUser(user);
        useraddressRepo.save(useraddress);
        return "address added successfully";
    }
    public  String edituseraddress(Useraddressdto useraddressdto) {
        Users user = userRepo.findById(useraddressdto.getUserId()).orElseThrow(() -> new RuntimeException("Invalid user"));
        Useraddress useraddress = useraddressRepo.findById(useraddressdto.getId()).orElseThrow(() -> new RuntimeException("user not found"));
        if (nonNull(useraddressdto.getHousename())) {
            useraddress.setHousename(useraddressdto.getHousename());
        }
        if (nonNull(useraddressdto.getLocality())) {
            useraddress.setLocality(useraddressdto.getHousename());
        }
        if (nonNull(useraddressdto.getDistrict())) {
            useraddress.setDistrict(useraddressdto.getDistrict());
        }
        if (nonNull(useraddressdto.getState())) {
            useraddress.setState(useraddressdto.getState());
        }
        if (nonNull(useraddressdto.getCountry())) {
            useraddress.setCountry(useraddressdto.getCountry());
        }
        if (nonNull(useraddressdto.getPhno())) {
            useraddress.setPhno(useraddressdto.getPhno());
        }
        if (nonNull(useraddressdto.getPincode())) {
            useraddress.setPincode(useraddressdto.getPincode());
        }
        useraddress.setUser(user);
        useraddressRepo.save(useraddress);
        return "address edited successfully";

    }
}
