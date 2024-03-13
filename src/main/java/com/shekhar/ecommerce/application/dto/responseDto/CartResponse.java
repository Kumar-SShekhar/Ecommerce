package com.shekhar.ecommerce.application.dto.responseDto;

import com.shekhar.ecommerce.application.model.Product;
import com.shekhar.ecommerce.application.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CartResponse {

    private Long id;
    private String name;
    private Integer cartValue;

//    private Long userId;
    private User user;

//    private Long productId;
    private List<Product> products;
}
