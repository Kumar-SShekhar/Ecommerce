package com.shekhar.ecommerce.application.repository;

import com.shekhar.ecommerce.application.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
