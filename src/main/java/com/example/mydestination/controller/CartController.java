package com.example.mydestination.controller;

import com.example.mydestination.constants.ApiRoutes;
import com.example.mydestination.dto.Cartdto;
import com.example.mydestination.model.Cart;
import com.example.mydestination.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(ApiRoutes.addTocart)
@RestController
public class CartController {
    @Autowired
    CartService cartService;

    @PostMapping("/add-Cart")
    public ResponseEntity<?> addtocart(@RequestParam (name = "id") Long id,@RequestParam(name="proid") Long proid)
    {
            Cart cart = cartService.addtocart(id,proid);
            return ResponseEntity.ok().body(cart);
    }

}
