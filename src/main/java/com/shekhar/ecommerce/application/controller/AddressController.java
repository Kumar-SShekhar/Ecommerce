package com.shekhar.ecommerce.application.controller;

import com.shekhar.ecommerce.application.dto.requestDto.AddressRequest;
import com.shekhar.ecommerce.application.model.Address;
import com.shekhar.ecommerce.application.service.AddressService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    @PostMapping("/new")
    public Address addNewAddress(@RequestBody AddressRequest addressRequest){
        return addressService.addAddress(addressRequest);
    }

    @GetMapping("/all")
    public List<Address> getAll(){
        return addressService.findAllAddress();
    }


    @GetMapping("/all-address-by-userId/{userId}")
    public List<Address> getAllAddressOfUserByUserId(@PathVariable Long userId){
        return addressService.findAddressOfUserByUserId(userId);
    }
    @GetMapping("/all-address-by-email/{email}")
    public List<Address> getAllAddressOfAUser(@PathVariable String email){
        return addressService.findAddressOfUserByEmail(email);
    }

    @DeleteMapping("/delete/{id}")
    public Address deleteAddress(@PathVariable Long id){
        return addressService.deleteAddress(id);
    }

    @PatchMapping("/update/{id}")
    public Address updateAddress(@PathVariable Long id, @RequestBody AddressRequest addressRequest){
        return addressService.updateAddress(id,addressRequest);
    }
}
