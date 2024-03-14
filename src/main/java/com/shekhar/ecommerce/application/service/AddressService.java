package com.shekhar.ecommerce.application.service;

import com.shekhar.ecommerce.application.dto.requestDto.AddressRequest;
import com.shekhar.ecommerce.application.dto.responseDto.AddressResponse;
import com.shekhar.ecommerce.application.model.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {

    public AddressResponse addAddress(AddressRequest addressRequest);
    public List<AddressResponse> findAllAddress();
    public AddressResponse updateAddress(Long id,AddressRequest addressRequest);
    public AddressResponse deleteAddress(Long id);


    public List<AddressResponse> findAddressOfUserByUserId(Long userId);
    public List<AddressResponse> findAddressOfUserByEmail(String email);

}
