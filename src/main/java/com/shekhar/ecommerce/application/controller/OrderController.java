package com.shekhar.ecommerce.application.controller;

import com.shekhar.ecommerce.application.dto.responseDto.OrderResponse;
import com.shekhar.ecommerce.application.model.OrderEntity;
import com.shekhar.ecommerce.application.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/new/{cartId}")
    public OrderEntity placeOrder(@PathVariable Long cartId){
        return orderService.placeOrder(cartId);
    }

    @GetMapping("/id/{id}")
    public OrderResponse getOrderById(@PathVariable Long id){
        return orderService.findOrderById(id);
    }

    @GetMapping("/all/{userId}")
    public List<OrderResponse> getAllOrdersOfAUser(@PathVariable Long userId){
        return orderService.findAllOrders(userId);
    }

    @PostMapping("/order-cancel/{userId}/{id}")
    public OrderResponse cancelOrder(@PathVariable Long userId,  @PathVariable Long id){
        return orderService.cancelOrder(userId, id);
    }

    @PostMapping("/confirm-order-delivery/{id}")
    public OrderResponse confirmOrderDelivery(@PathVariable Long id){
        return orderService.markOrderDelivered(id);
    }

    @PostMapping("/update-order/{id}")
    public OrderResponse updateOrder(@PathVariable Long id, @RequestBody OrderEntity order){
        return orderService.updateOrder(id,order);
    }

}
