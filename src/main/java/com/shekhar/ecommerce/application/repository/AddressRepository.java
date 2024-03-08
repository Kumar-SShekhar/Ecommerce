package com.shekhar.ecommerce.application.repository;

import com.shekhar.ecommerce.application.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findByUserId(Long userId);
    List<Address> findByUserEmail(String email);
}
