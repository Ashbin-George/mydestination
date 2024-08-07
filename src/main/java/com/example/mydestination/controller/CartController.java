package com.example.mydestination.controller;

import com.example.mydestination.constants.ApiRoutes;
import com.example.mydestination.dto.Cartdto;
import com.example.mydestination.model.Cart;
import com.example.mydestination.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PutMapping("decrement-cart")
    public ResponseEntity<?> decrement(@RequestParam(name = "id") Long id,@RequestParam(name="proid") Long proid)
    {
        try
        {
            String result= cartService.decrementproduct(id,proid);
            return ResponseEntity.ok().body(result);
        }
        catch (Exception ex)
        {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("failed to decrement product");
        }

    }
    @DeleteMapping("remove-cart")
    public ResponseEntity<?> removecart (@RequestParam(name="id")Long id,@RequestParam(name="proid") Long proid)
    {
        try
        {
            String result = cartService.removecart(id,proid);
            return ResponseEntity.ok().body(result);
        }
        catch (Exception ex)
        {
            return  ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(("failed to remove product"));
        }
    }
}
