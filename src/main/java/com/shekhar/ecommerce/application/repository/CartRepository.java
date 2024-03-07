package com.shekhar.ecommerce.application.repository;

import com.shekhar.ecommerce.application.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
