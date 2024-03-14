package com.shekhar.ecommerce.application.service.impl;

import com.shekhar.ecommerce.application.dto.requestDto.AddressRequest;
import com.shekhar.ecommerce.application.dto.responseDto.AddressResponse;
import com.shekhar.ecommerce.application.mapper.AddressMapper;
import com.shekhar.ecommerce.application.model.Address;
import com.shekhar.ecommerce.application.repository.AddressRepository;
import com.shekhar.ecommerce.application.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;
    private final AddressMapper addressMapper;

    @Override
    public AddressResponse addAddress(AddressRequest addressRequest) {
        Address address = addressMapper.mapAddressRequestToAddress(addressRequest);
        addressRepository.save(address);

        return addressMapper.mapAddressToAddressResponse(address);

    }

    @Override
    public List<AddressResponse> findAllAddress() {
        List<Address> addresses = addressRepository.findAll();
        return addressMapper.mapAddressesToAddressResponses(addresses);
    }


    @Override
    public AddressResponse updateAddress(Long id, AddressRequest addressRequest) {
        Address address = addressMapper.mapAddressRequestToAddress(addressRequest);
        addressRepository.save(address);
        return addressMapper.mapAddressToAddressResponse(address);
    }

    @Override
    public AddressResponse deleteAddress(Long id) {
        Address address = addressRepository.findById(id).orElseThrow(()-> new RuntimeException("Address not found with id:"+id));
        addressRepository.delete(address);
        return addressMapper.mapAddressToAddressResponse(address);
    }


    @Override
    public List<AddressResponse> findAddressOfUserByUserId(Long userId) {
        List<Address> addresses = addressRepository.findByUserId(userId);
        return addressMapper.mapAddressesToAddressResponses(addresses);
    }
    @Override
    public List<AddressResponse> findAddressOfUserByEmail(String email){
        List<Address> addresses = addressRepository.findByUserEmail(email);
        return addressMapper.mapAddressesToAddressResponses(addresses);
    }


}
