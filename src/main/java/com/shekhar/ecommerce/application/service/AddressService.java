package com.shekhar.ecommerce.application.service;

import com.shekhar.ecommerce.application.dto.requestDto.AddressRequest;
import com.shekhar.ecommerce.application.dto.responseDto.AddressResponse;
import com.shekhar.ecommerce.application.model.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {

    public Address addAddress(AddressRequest addressRequest);
    public List<AddressResponse> findAllAddress();
    public Address updateAddress(Long id,AddressRequest addressRequest);
    public Address deleteAddress(Long id);


    public List<Address> findAddressOfUserByUserId(Long userId);
    public List<Address> findAddressOfUserByEmail(String email);

}
