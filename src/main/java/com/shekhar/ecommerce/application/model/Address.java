package com.shekhar.ecommerce.application.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String addressLine1;
    private String addressLine2;
    private String city;
    private String postalCode;
    private String state;
    private String phoneNumber;




    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
