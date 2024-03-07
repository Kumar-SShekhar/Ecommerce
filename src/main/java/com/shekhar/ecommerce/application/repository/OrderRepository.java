package com.shekhar.ecommerce.application.repository;

import com.shekhar.ecommerce.application.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}