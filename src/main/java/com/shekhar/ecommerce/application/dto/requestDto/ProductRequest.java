package com.shekhar.ecommerce.application.dto.requestDto;

import com.shekhar.ecommerce.application.model.Category;
import com.shekhar.ecommerce.application.model.Seller;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class ProductRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotNull
    private Integer price;
    private String quantity;
    private boolean isAvailable;

    private Category category;

    private Seller seller;
}
