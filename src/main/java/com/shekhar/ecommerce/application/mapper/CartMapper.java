package com.shekhar.ecommerce.application.mapper;

import com.shekhar.ecommerce.application.dto.requestDto.CartRequest;
import com.shekhar.ecommerce.application.dto.responseDto.CartResponse;
import com.shekhar.ecommerce.application.model.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CartMapper {

    Cart mapCartRequestToCart(CartRequest cartRequest);
    CartResponse mapCartToCartResponse(Cart cart);

}
