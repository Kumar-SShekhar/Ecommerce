package com.shekhar.ecommerce.application.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private Integer orderValue;
    private LocalDateTime orderDate;

    private LocalDateTime deliveryDate;

    private OrderStatus orderStatus;

    @OneToOne
//    @JoinColumn(name = "cart_id", insertable = false, updatable = false)
//    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
