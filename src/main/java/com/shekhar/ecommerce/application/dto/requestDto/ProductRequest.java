package com.shekhar.ecommerce.application.dto.requestDto;

import com.shekhar.ecommerce.application.model.Category;
import com.shekhar.ecommerce.application.model.Seller;
import lombok.Getter;

@Getter
public class ProductRequest {

    private String name;
    private String description;
    private Integer price;
    private String quantity;
    private boolean isAvailable;

    private Category category;

    private Seller seller;
}
