package com.shekhar.ecommerce.application.repository;

import com.shekhar.ecommerce.application.model.OrderEntity;
import com.shekhar.ecommerce.application.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    public List<OrderEntity> findByUserId(Long userId);

    public List<OrderEntity> findByOrderStatus(OrderStatus orderStatus);
}