package com.example.mydestination.controller;

import com.example.mydestination.constants.ApiRoutes;
import com.example.mydestination.dto.Productsdto;
import com.example.mydestination.service.Productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(ApiRoutes.addProducts)
@RestController
public class ProductController {

    @Autowired
    Productservice productservice;

    @PostMapping("/add-product")
    public ResponseEntity<?> addProduct(@RequestBody Productsdto productsdto)
    {
        try
        {
            String result = productservice.addproduct(productsdto);
            return ResponseEntity.ok().body(result);
        }
        catch (Exception ex)
        {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("failed to add product");
        }
    }
    @PutMapping("/edit-product")
    public ResponseEntity<?> editproduct(@RequestParam(name="proid")Long proid,@RequestParam(name="proname")String NewProname,
                                         @RequestParam(name="prospec")String NewProspec,@RequestParam(name="proprize")int NewPrize)
    {
        try
        {
            String result=productservice.editProduct(proid,NewProname,NewProspec,NewPrize);
            return ResponseEntity.ok().body(result);
        }
        catch (Exception ex)
        {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Failed to edit product details");
        }

    }
    @GetMapping("get-product")
    public ResponseEntity<?>getProduct(@RequestParam(name="proid")Long proid)
    {
        try
        {
            Productsdto productsdto= productservice.getProduct(proid);
            return  ResponseEntity.ok().body(productsdto);

        }catch (Exception ex)
        {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("failed get product details");
        }
    }
    @DeleteMapping("delete-product")
    public  ResponseEntity<?>deleteProduct(@RequestParam(name="proid")Long proid)
    {
        try
        {
            String result=productservice.deleteProduct(proid);
            return ResponseEntity.ok().body(result);
        }
        catch (Exception ex)
        {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Failed to delete product");
        }
    }

    @GetMapping("get-product-all")
    public ResponseEntity<?> getProductAll()
    {
        try
        {
            List<Productsdto> productsdto= productservice.getProductAll();
            return  ResponseEntity.ok().body(productsdto);

        }catch (Exception ex)
        {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("failed get product details");
        }
    }
}
