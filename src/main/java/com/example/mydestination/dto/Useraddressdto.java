package com.example.mydestination.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Useraddressdto
    {
        Long id;
        String housename;
        String locality;
        String District;
        String state;
        String country;
        Integer pincode;
        String phno;
        Long userId;
    }
