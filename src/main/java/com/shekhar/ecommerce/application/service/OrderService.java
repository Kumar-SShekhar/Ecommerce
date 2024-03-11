package com.shekhar.ecommerce.application.service;

import com.shekhar.ecommerce.application.model.Order;
import com.shekhar.ecommerce.application.model.User;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    public Order placeOrder(Long cartId);
    public User findUser(Long userId);
    public List<Order> findAllOrders(Long userId);
    public Order findOrderById(Long id);
    public Order cancelOrder(Long userId, Long id);
    public Order markOrderDelivered(Long id );
    public Order updateOrder(Long id, Order order);

}
