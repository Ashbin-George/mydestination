package com.example.mydestination.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cartdto
{
    String pdtName;
    Integer quantity;
    Integer totalPrice;
}
