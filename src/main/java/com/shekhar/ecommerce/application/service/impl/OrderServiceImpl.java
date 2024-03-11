package com.shekhar.ecommerce.application.service.impl;

import com.shekhar.ecommerce.application.model.Cart;
import com.shekhar.ecommerce.application.model.Order;
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
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final CartService cartService;

    @Override
    public Order placeOrder(Long cartId) {
        Cart cart =  cartService.findCart(cartId);
        User user = cart.getUser();
        if(cart.getProducts().isEmpty()){
            throw new RuntimeException("Cart is empty");
        }

        Order order = new Order();
        order.setUser(user);
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
    public User findUser(Long userId) {
        return null;
    }

    @Override
    public List<Order> findAllOrders(Long userId) {
        List<Order> orders = orderRepository.findByUserId(userId);
        return orders;
    }

    @Override
    public Order findOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found with id: "+ id));
    }

    @Override
    public Order cancelOrder(Long userId, Long id) {
        Order order = findOrderById(id);
        if(order.getOrderStatus() == OrderStatus.ORDERED){
            order.setOrderStatus(OrderStatus.CANCELLED);
            orderRepository.save(order);
            return order;
        }
        return null;
    }

    @Override
    public Order markOrderDelivered(Long id) {
        Order order =  findOrderById(id);
        if(order.getOrderStatus() == OrderStatus.ORDERED){
            order.setOrderStatus(OrderStatus.DELIVERED);
            orderRepository.save(order);
            return order;
        }
        throw new IllegalArgumentException("Order is either delivered or cancelled");
    }



    @Override
    public Order updateOrder(Long id, Order order) {
        return null;
    }

}
