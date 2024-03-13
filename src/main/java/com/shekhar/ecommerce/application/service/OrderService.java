package com.shekhar.ecommerce.application.service;

import com.shekhar.ecommerce.application.dto.responseDto.OrderResponse;
import com.shekhar.ecommerce.application.model.OrderEntity;
import com.shekhar.ecommerce.application.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    public OrderEntity placeOrder(Long cartId);
    public OrderEntity findOrder(Long id);
    public List<OrderResponse> findAllOrders(Long userId);
    public OrderResponse findOrderById(Long id);
    public OrderResponse cancelOrder(Long userId, Long id);
    public OrderResponse markOrderDelivered(Long id );
    public OrderResponse updateOrder(Long id, OrderEntity order);

}
