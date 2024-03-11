package com.shekhar.ecommerce.application.service;

import com.shekhar.ecommerce.application.model.OrderEntity;
import com.shekhar.ecommerce.application.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    public OrderEntity placeOrder(Long cartId);
    public User findUser(Long userId);
    public List<OrderEntity> findAllOrders(Long userId);
    public OrderEntity findOrderById(Long id);
    public OrderEntity cancelOrder(Long userId, Long id);
    public OrderEntity markOrderDelivered(Long id );
    public OrderEntity updateOrder(Long id, OrderEntity order);

}
