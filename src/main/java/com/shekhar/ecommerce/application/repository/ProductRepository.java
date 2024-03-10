package com.shekhar.ecommerce.application.repository;

import com.shekhar.ecommerce.application.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    public List<Product> findByCategoryId(Long categoryId);

}
