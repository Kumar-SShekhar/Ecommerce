package com.shekhar.ecommerce.application.service;

import com.shekhar.ecommerce.application.model.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {

    public Address addAddress(Address address);
    public List<Address> findAllAddress();
    public Address updateAddress(Long id,Address address);
    public Address deleteAddress(Long id);
}
