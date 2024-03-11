package com.shekhar.ecommerce.application.controller;

import com.shekhar.ecommerce.application.model.Order;
import com.shekhar.ecommerce.application.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/new/{cartId}")
    public Order placeOrder(@PathVariable Long cartId){
        return orderService.placeOrder(cartId);
    }

    @GetMapping("/id/{id}")
    public Order getOrderById(@PathVariable Long id){
        return orderService.findOrderById(id);
    }

    @GetMapping("/all/{userId}")
    public List<Order> getAllOrdersOfAUser(@PathVariable Long userId){
        return orderService.findAllOrders(userId);
    }

    @PostMapping("/order-cancel/{userId}/{id}")
    public Order cancelOrder(@PathVariable Long userId,  @PathVariable Long id){
        return orderService.cancelOrder(userId, id);
    }

    @PostMapping("/confirm-order-delivery/{id}")
    public Order confirmOrderDelivery(@PathVariable Long id){
        return orderService.markOrderDelivered(id);
    }

    @PostMapping("/update-order/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order order){
        return orderService.updateOrder(id,order);
    }

}
