package com.shekhar.ecommerce.application.dto.responseDto;

import com.shekhar.ecommerce.application.model.Category;
import com.shekhar.ecommerce.application.model.Seller;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {

    private Long id;
    private String name;
    private String description;
    private Integer price;
    private String quantity;
    private boolean isAvailable;

    private Long categoryId;
//    private Category category;

    private Long sellerId;
//    private Seller seller;
}
