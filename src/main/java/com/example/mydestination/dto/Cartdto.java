package com.example.mydestination.dto;

import com.example.mydestination.model.Products;
import com.example.mydestination.model.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cartdto
    {
        Products products;
        Integer quantity;
        Users user;
        Timestamp CreatedAt;
        Timestamp ModifiedAt;
    }
