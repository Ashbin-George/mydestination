package com.example.mydestination.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "cart")
@Getter
@Setter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name="product_id",referencedColumnName = "proid")
    Products products;

    @Column(name="quantity")
    Integer quantity;

    @ManyToOne
    @JoinColumn(name="user_id",referencedColumnName = "id")
    Users user;


    @Column(name = "created_at")
    Timestamp CreatedAt;

    @Column(name="modified_at")
    Timestamp ModifiedAt;
}
