package com.example.mydestination.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_address")
@Getter
@Setter
public class Useraddress 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name="user_id",referencedColumnName = "id")
    Users user;

    @Column(name = "housename")
    private String housename;

    @Column(name = "locality")
    private String locality;

    @Column(name = "district")
    private String District;

    @Column(name = "state")
    private String State;

    @Column(name= "country")
    private String country;

    @Column( name ="pincode")
    private int pincode;

    @Column(name = "phno")
    private String phno;
}
