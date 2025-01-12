package com.example.mydestination.repository;

import com.example.mydestination.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartRepo extends JpaRepository <Cart,Long>
{
    @Query(value = "SELECT * FROM cart WHERE product_id =:productID AND user_id = :userID", nativeQuery = true)
    Cart findPresentCart(@Param("productID") Long productId, @Param("userID") Long userId);

    @Query(value= "SELECT * FROM cart WHERE user_id = :user_id", nativeQuery = true)
    List<Cart> findCartDetailsOfAUser(@Param("user_id") Long userId);
}
