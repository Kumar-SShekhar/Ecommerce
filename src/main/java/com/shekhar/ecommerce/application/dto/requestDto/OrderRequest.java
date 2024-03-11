package com.shekhar.ecommerce.application.dto.requestDto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
public class OrderRequest {

    private String name;
    private Integer price;
//    private LocalDateTime orderDate;
//    private LocalDateTime deliveryDate;
}
