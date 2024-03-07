package com.shekhar.ecommerce.application.repository;

import com.shekhar.ecommerce.application.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
