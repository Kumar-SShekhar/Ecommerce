package com.shekhar.ecommerce.application.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private Integer price;
    private LocalDateTime orderDate;

    private LocalDateTime deliveryDate;

    private OrderStatus orderStatus;

    @OneToOne()
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
