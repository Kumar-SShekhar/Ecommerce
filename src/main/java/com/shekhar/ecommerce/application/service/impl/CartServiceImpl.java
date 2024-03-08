package com.shekhar.ecommerce.application.service.impl;

import com.shekhar.ecommerce.application.dto.requestDto.CartRequest;
import com.shekhar.ecommerce.application.model.Cart;
import com.shekhar.ecommerce.application.model.Product;
import com.shekhar.ecommerce.application.service.CartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Override
    public Cart createCart(CartRequest cartRequest) {
        return null;
    }

    @Override
    public List<Product> findAllProductsInCart(Long productId) {
        return null;
    }

    @Override
    public Cart addProductToCart() {
        return null;
    }
}
