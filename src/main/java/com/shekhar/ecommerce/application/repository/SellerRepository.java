package com.shekhar.ecommerce.application.repository;

import com.shekhar.ecommerce.application.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
