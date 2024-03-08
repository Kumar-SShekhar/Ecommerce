package com.shekhar.ecommerce.application.service.impl;

import com.shekhar.ecommerce.application.dto.requestDto.AddressRequest;
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

    @Override
    public Address addAddress(AddressRequest addressRequest) {
//        Address address = new Address();
//        address.setName(addressRequest.getName());
//        address.setAddressLine1(addressRequest.getAddressLine1());
//        address.setAddressLine2(addressRequest.getAddressLine2());
//        address.setCity(addressRequest.getCity());
//        address.setPostalCode(addressRequest.getPostalCode());
//        address.setState(addressRequest.getState());
//        address.setPhoneNumber(addressRequest.getPhoneNumber());
//        address.setUser(addressRequest.getUser());

        Address address1 = modelMapper.map(addressRequest, Address.class);
        addressRepository.save(address1);
        return address1;

    }

    @Override
    public List<Address> findAllAddress() {
        return addressRepository.findAll();
    }


    @Override
    public List<Address> findAddressOfUserByUserId(Long userId) {
        return addressRepository.findByUserId(userId);
    }
    @Override
    public List<Address> findAddressOfUserByEmail(String email){
        return addressRepository.findByUserEmail(email);
    }


    @Override
    public Address updateAddress(Long id, AddressRequest addressRequest) {
        Address address = addressRepository.findById(id).orElseThrow(()-> new RuntimeException("Address not found with id:"+id));
//        Address updatedAddress = modelMapper.map(addressRequest, Address.class);
//        return addressRepository.save(updatedAddress);
//        BeanUtils.copyProperties(addressRequest, address);
//        return addressRepository.save(address);


        address.setName(addressRequest.getName());
        address.setAddressLine1(addressRequest.getAddressLine1());
        address.setAddressLine2(addressRequest.getAddressLine2());
        address.setCity(addressRequest.getCity());
        address.setPostalCode(addressRequest.getPostalCode());
        address.setState(addressRequest.getState());
        address.setPhoneNumber(addressRequest.getPhoneNumber());
        return addressRepository.save(address);
    }

    @Override
    public Address deleteAddress(Long id) {
        Address address = addressRepository.findById(id).orElseThrow(()-> new RuntimeException("Address not found with id:"+id));
        addressRepository.delete(address);
        return address;
    }


}
