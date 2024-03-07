package com.shekhar.ecommerce.application.service;

import com.shekhar.ecommerce.application.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    public Order addOrder(Order order);
    public List<Order> getAllOrders();
    public Order updateOrder(Long id, Order order);
    public Order deleteOrder(Long id);
}
