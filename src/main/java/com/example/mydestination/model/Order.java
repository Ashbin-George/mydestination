//package com.example.mydestination.model;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//@Entity
//@Table(name="order")
//@Getter
//@Setter
//public class Order {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long orderid;
//
//    @Column(name = "orderdate")
//    private String orderdate;
//
//    @Column(name = "orderstatus")
//    private String orderstatus;
//
//    @Column(name ="ordertotal")
//    private int ordertotal;
//
//    @Column(name = "ordertype")
//    private String ordertype;
//
//    @ManyToOne
//    @JoinColumn(name="user_id",referencedColumnName = "id")
//    Users user;
//
//    @ManyToOne
//    @JoinColumn(name = "cart_id",referencedColumnName = "id")
//    Cart cart;
//}
