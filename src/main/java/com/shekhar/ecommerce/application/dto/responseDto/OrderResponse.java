package com.shekhar.ecommerce.application.dto.responseDto;

import com.shekhar.ecommerce.application.model.Cart;
import com.shekhar.ecommerce.application.model.OrderStatus;
import com.shekhar.ecommerce.application.model.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrderResponse {

    private Long id;
    private String name;

    private Integer orderValue;
    private LocalDateTime orderDate;

    private LocalDateTime deliveryDate;

    private OrderStatus orderStatus;

    private Long cartId;

    private Long userId;
}
