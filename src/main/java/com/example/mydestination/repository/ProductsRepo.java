package com.example.mydestination.repository;

import com.example.mydestination.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepo extends JpaRepository<Products,Long> {
}
