package com.shekhar.ecommerce.application.controller;

import com.shekhar.ecommerce.application.customresponse.ApiResponse;
import com.shekhar.ecommerce.application.dto.responseDto.OrderResponse;
import com.shekhar.ecommerce.application.model.OrderEntity;
import com.shekhar.ecommerce.application.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/new/{cartId}")
    public ResponseEntity<ApiResponse> placeOrder(@PathVariable Long cartId){
        OrderResponse orderResponse = orderService.placeOrder(cartId);
        ApiResponse apiResponse = new ApiResponse("Success", "Data Found", orderResponse);
        return ResponseEntity.status(200).body(apiResponse);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ApiResponse> getOrderById(@PathVariable Long id){
        OrderResponse orderResponse = orderService.findOrderById(id);
        ApiResponse apiResponse = new ApiResponse("Success", "Data Found",  orderResponse);
        return ResponseEntity.status(200).body(apiResponse);
    }

    @GetMapping("/all/{userId}")
    public ResponseEntity<ApiResponse> getAllOrdersOfAUser(@PathVariable Long userId){
        List<OrderResponse> orderResponses = orderService.findAllOrders(userId);
        ApiResponse apiResponse = new ApiResponse("Success", "Data Found", orderResponses);
        return ResponseEntity.status(200).body(apiResponse);
    }

    @PostMapping("/order-cancel/{userId}/{id}")
    public ResponseEntity<ApiResponse> cancelOrder(@PathVariable Long userId,  @PathVariable Long id){
        OrderResponse orderResponse = orderService.cancelOrder(userId, id);
        ApiResponse apiResponse = new ApiResponse("Success", "Data Found",  orderResponse);
        return ResponseEntity.status(200).body(apiResponse);
    }

    @PostMapping("/confirm-order-delivery/{id}")
    public ResponseEntity<ApiResponse> confirmOrderDelivery(@PathVariable Long id){
        OrderResponse orderResponse = orderService.markOrderDelivered(id);
        ApiResponse apiResponse = new ApiResponse("Success", "Data Found",  orderResponse);
        return ResponseEntity.status(200).body(apiResponse);
    }

    @PostMapping("/update-order/{id}")
    public ResponseEntity<ApiResponse> updateOrder(@PathVariable Long id, @RequestBody OrderEntity order){
        OrderResponse orderResponse = orderService.updateOrder(id,order);
        ApiResponse apiResponse = new ApiResponse("Success", "Data Found",  orderResponse);
        return ResponseEntity.status(200).body(apiResponse);
    }

}
