package com.shekhar.ecommerce.application.controller;

import com.shekhar.ecommerce.application.customresponse.ApiResponse;
import com.shekhar.ecommerce.application.dto.requestDto.CartRequest;
import com.shekhar.ecommerce.application.dto.responseDto.CartResponse;
import com.shekhar.ecommerce.application.dto.responseDto.ProductResponse;
import com.shekhar.ecommerce.application.model.Product;
import com.shekhar.ecommerce.application.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping("/new")
    public ResponseEntity<ApiResponse> createCart(@RequestBody CartRequest cartRequest){
        CartResponse cartResponse = cartService.createCart(cartRequest);
        ApiResponse apiResponse = new ApiResponse("Success", "Data Found", cartResponse);
        return ResponseEntity.status(200).body(apiResponse);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ApiResponse> getCartById(@PathVariable Long id){
        CartResponse cartResponse = cartService.findCartById(id);
        ApiResponse apiResponse = new ApiResponse("Success", "Data Found", cartResponse);
        return ResponseEntity.status(200).body(apiResponse);
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<ApiResponse> getAllProductsInCart(@PathVariable Long id){
        List<ProductResponse> productResponses = cartService.findAllProductsInCart(id);
        ApiResponse apiResponse = new ApiResponse("Success", "Data Found", productResponses);
        return ResponseEntity.status(200).body(apiResponse);
    }

    @PostMapping("/addProduct/{id}/{productId}")
    public ResponseEntity<ApiResponse> addProductToCart(@PathVariable Long id, @PathVariable Long productId){
        CartResponse cartResponse = cartService.addProductToCart(id, productId);
        ApiResponse apiResponse = new ApiResponse("Success", "Data Found", cartResponse);
        return ResponseEntity.status(200).body(apiResponse);
    }

    @PostMapping("/removeProduct/{id}/{productId}")
    public ResponseEntity<ApiResponse> removeProductFromCart(@PathVariable Long id, @PathVariable Long productId){
        CartResponse cartResponse = cartService.removeProductFromCart(id, productId);
        ApiResponse apiResponse = new ApiResponse("Success", "Data Found", cartResponse);
        return ResponseEntity.status(200).body(apiResponse);
    }

    @GetMapping("/cartValue/{id}")
    public ResponseEntity<ApiResponse> getCartValue(@PathVariable Long id){
        Integer cartValue = cartService.findCartValue(id);
        ApiResponse apiResponse = new ApiResponse("Success", "Data Found", cartValue);
        return ResponseEntity.status(200).body(apiResponse);
    }

}