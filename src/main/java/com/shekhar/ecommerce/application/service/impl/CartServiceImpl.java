package com.shekhar.ecommerce.application.service.impl;

import com.shekhar.ecommerce.application.dto.requestDto.CartRequest;
import com.shekhar.ecommerce.application.dto.responseDto.CartResponse;
import com.shekhar.ecommerce.application.dto.responseDto.ProductResponse;
import com.shekhar.ecommerce.application.model.Cart;
import com.shekhar.ecommerce.application.model.Product;
import com.shekhar.ecommerce.application.repository.CartRepository;
import com.shekhar.ecommerce.application.repository.ProductRepository;
import com.shekhar.ecommerce.application.service.CartService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final ModelMapper modelMapper;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    @Override
    public CartResponse createCart(CartRequest cartRequest) {
        Cart cart = modelMapper.map(cartRequest, Cart.class);
        cartRepository.save(cart);
        return modelMapper.map(cart, CartResponse.class);
    }

    @Override
    public Cart findCart(Long id) {
        return cartRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Cart not Found with id:"+id));
    }

    @Override
    public CartResponse findCartById(Long id) {
        Cart cart = findCart(id);
        return modelMapper.map(cart, CartResponse.class);
    }

    @Override
    public List<ProductResponse> findAllProductsInCart(Long id) {
        Cart cart = findCart(id);
        List<Product> products = cart.getProducts();
        List<ProductResponse> productResponses = products.stream()
                .map(product -> modelMapper.map(product, ProductResponse.class)).toList();
        return productResponses;
    }


    @Override
    public CartResponse addProductToCart(Long id, Long productId) {
        Cart cart = findCart(id);
        Product product = productRepository.findById(productId).orElseThrow(()-> new IllegalArgumentException("Product not found "));

        Integer previousCartValue = findCartValue(id);
        cart.addProduct(product);
        cart.setCartValue(previousCartValue + product.getPrice());  //....
        cartRepository.save(cart);
        return modelMapper.map(cart, CartResponse.class);
    }

    @Override
    public CartResponse removeProductFromCart(Long id, Long productId) {
        Cart cart = findCart(id);
        Product product = productRepository.findById(productId).orElseThrow(()-> new IllegalArgumentException("Product not found"));
        List<Product> productsList = cart.getProducts();
        if(!productsList.contains(product)){  // When cart doesn't contain that product
            return null;
        }
        cart.removeProduct(product);
        Integer prevCartValue = cart.getCartValue();
        cart.setCartValue(prevCartValue - product.getPrice());
        cartRepository.save(cart);
        return modelMapper.map(cart, CartResponse.class);
    }

    @Override
    public Integer findCartValue(Long id) {
        Cart cart = findCart(id);
        List<Product> products = cart.getProducts();
//        Integer cartValue = products.stream().map(product -> product.getPrice()).reduce(0, Integer::sum);
        Integer cartValue = products.stream().mapToInt(product -> product.getPrice()).sum();
        cart.setCartValue(cartValue);
        cartRepository.save(cart);
        return cartValue;
    }
}
