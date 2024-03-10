package com.shekhar.ecommerce.application.service;

import com.shekhar.ecommerce.application.dto.requestDto.CartRequest;
import com.shekhar.ecommerce.application.dto.responseDto.CartResponse;
import com.shekhar.ecommerce.application.model.Cart;
import com.shekhar.ecommerce.application.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {

    public CartResponse createCart(CartRequest cartRequest);
    public Cart findCart(Long id);
    public CartResponse findCartById(Long id);
    public List<Product> findAllProductsInCart(Long productId);
    public CartResponse addProductToCart(Long id, Long productId);

    public CartResponse removeProductFromCart(Long id, Long productId);
    public Integer findCartValue(Long id);
}
