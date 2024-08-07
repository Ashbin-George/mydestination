package com.example.mydestination.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Products
{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long proid;

        @Column(name = "proname")
        private String proname;

        @Column(name="prospec")
        private String prospec;

        @Column(name = "proprize")
        private int proprize;

}
