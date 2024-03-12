package com.shekhar.ecommerce.application.admin;

import com.shekhar.ecommerce.application.model.*;
import com.shekhar.ecommerce.application.repository.OrderRepository;
import com.shekhar.ecommerce.application.repository.ProductRepository;
import com.shekhar.ecommerce.application.repository.SellerRepository;
import com.shekhar.ecommerce.application.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService{

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final SellerRepository sellerRepository;


    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<OrderEntity> findAllActiveOrders() {
        return orderRepository.findByOrderStatus(OrderStatus.ORDERED);
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Seller> findAllSellers() {
        return sellerRepository.findAll();
    }
}
