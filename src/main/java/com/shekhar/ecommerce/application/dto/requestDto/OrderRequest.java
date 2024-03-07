package com.shekhar.ecommerce.application.dto.requestDto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class OrderRequest {

    private String name;
    private LocalDateTime orderDate;
    private LocalDateTime deliveryDate;
}
