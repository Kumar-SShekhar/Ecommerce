package com.shekhar.ecommerce.application.service;

import com.shekhar.ecommerce.application.dto.requestDto.CartRequest;
import com.shekhar.ecommerce.application.model.Cart;
import com.shekhar.ecommerce.application.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {

    public Cart createCart(CartRequest cartRequest);
    public List<Product> findAllProductsInCart(Long productId);
    public Cart addProductToCart();
}
