package com.shekhar.ecommerce.application.service.impl;

import com.shekhar.ecommerce.application.dto.responseDto.OrderResponse;
import com.shekhar.ecommerce.application.mapper.OrderMapper;
import com.shekhar.ecommerce.application.model.Cart;
import com.shekhar.ecommerce.application.model.OrderEntity;
import com.shekhar.ecommerce.application.model.OrderStatus;
import com.shekhar.ecommerce.application.model.User;
import com.shekhar.ecommerce.application.repository.CartRepository;
import com.shekhar.ecommerce.application.repository.OrderRepository;
import com.shekhar.ecommerce.application.service.CartService;
import com.shekhar.ecommerce.application.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final CartService cartService;
    private final OrderMapper orderMapper;

    @Override
    public OrderEntity placeOrder(Long cartId) {
        Cart cart =  cartService.findCart(cartId);
        User user = cart.getUser();
        if(cart.getProducts().isEmpty()){
            throw new RuntimeException("Cart is empty");
        }

        OrderEntity order = new OrderEntity();
        order.setUser(user);
        order.setOrderValue(cartService.findCartValue(cartId));
        order.setOrderDate(LocalDateTime.now());
        LocalDateTime deliveryDate = order.getOrderDate().plusDays(7);
        order.setDeliveryDate(deliveryDate);
        order.setOrderStatus(OrderStatus.ORDERED);
        try {
            return orderRepository.save(order);
        } catch (DataAccessException ex) {
            throw new RuntimeException("Failed to place order", ex);
        }
    }

    @Override
    public OrderEntity findOrder(Long id) {
        return orderRepository.findById(id).orElseThrow(()-> new RuntimeException("Order not found with id: " +id));
    }

    @Override
    public List<OrderResponse> findAllOrders(Long userId) {
        List<OrderEntity> orders = orderRepository.findByUserId(userId);
        return orderMapper.mapOrdersToOrderResponses(orders);
    }

    @Override
    public OrderResponse findOrderById(Long id) {
        OrderEntity order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found with id: "+ id));
        return orderMapper.mapOrderToOrderResponse(order);
    }

    @Override
    public OrderResponse cancelOrder(Long userId, Long id) {
        OrderEntity order = findOrder(id);
        if(order.getOrderStatus() == OrderStatus.ORDERED){
            order.setOrderStatus(OrderStatus.CANCELLED);
            orderRepository.save(order);
            return orderMapper.mapOrderToOrderResponse(order);
        }
        return null;
    }

    @Override
    public OrderResponse markOrderDelivered(Long id) {
        OrderEntity order =  findOrder(id);
        if(order.getOrderStatus() == OrderStatus.ORDERED){
            order.setOrderStatus(OrderStatus.DELIVERED);
            orderRepository.save(order);
            return orderMapper.mapOrderToOrderResponse(order);
        }
        throw new IllegalArgumentException("Order is either delivered or cancelled");
    }



    @Override
    public OrderResponse updateOrder(Long id, OrderEntity order) {
        return null;
    }

}
