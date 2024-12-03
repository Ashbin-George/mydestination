//package com.example.mydestination.service;
//
//import com.example.mydestination.model.*;
//import com.example.mydestination.repository.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class OrderService {
//    @Autowired
//    UserRepo userRepo;
//    @Autowired
//    UseraddressRepo useraddressRepo;
//    @Autowired
//    ProductsRepo productsRepo;
//    @Autowired
//    CartRepo cartRepo;
//    @Autowired
//    OrderRepo orderRepo;
//
//    public Order placeorder(Long userid, Long addid, Long cartid)
//    {
//        Users user= userRepo.findById(userid).orElseThrow(() -> new RuntimeException("failed to find user"));
//        Useraddress useraddress= useraddressRepo.findById(addid).orElseThrow(()-> new RuntimeException("failed to find user address"));
//        Cart cart= cartRepo.findById(cartid).orElseThrow(()-> new RuntimeException("failed to find cart"));
//        if(user)
//        {
//
//        }
//    }
//}
