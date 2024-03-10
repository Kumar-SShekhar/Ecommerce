package com.shekhar.ecommerce.application.controller;

import com.shekhar.ecommerce.application.dto.requestDto.CartRequest;
import com.shekhar.ecommerce.application.dto.responseDto.CartResponse;
import com.shekhar.ecommerce.application.model.Product;
import com.shekhar.ecommerce.application.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping("/new")
    public CartResponse createCart(@RequestBody CartRequest cartRequest){
        return cartService.createCart(cartRequest);
    }

    @GetMapping("/id/{id}")
    public CartResponse getCartById(@PathVariable Long id){
        return cartService.findCartById(id);
    }

    @GetMapping("/all/{id}")
    public List<Product> getAllProductsInCart(@PathVariable Long id){
        return cartService.findAllProductsInCart(id);
    }

    @PostMapping("/addProduct/{id}/{productId}")
    public CartResponse addProductToCart(@PathVariable Long id, @PathVariable Long productId){
        return cartService.addProductToCart(id, productId);
    }

    @PostMapping("/removeProduct/{id}/{productId}")
    public CartResponse removeProductFromCart(@PathVariable Long id, @PathVariable Long productId){
        return cartService.removeProductFromCart(id, productId);
    }

    @GetMapping("/cartValue/{id}")
    public Integer getCartValue(@PathVariable Long id){
        return cartService.findCartValue(id);
    }

}