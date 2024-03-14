package com.shekhar.ecommerce.application.controller;

import com.shekhar.ecommerce.application.customresponse.ApiResponse;
import com.shekhar.ecommerce.application.dto.requestDto.AddressRequest;
import com.shekhar.ecommerce.application.dto.responseDto.AddressResponse;
import com.shekhar.ecommerce.application.model.Address;
import com.shekhar.ecommerce.application.service.AddressService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    @PostMapping("/new")
    public ResponseEntity<ApiResponse> addNewAddress(@RequestBody AddressRequest addressRequest){
        AddressResponse addressResponse = addressService.addAddress(addressRequest);
        ApiResponse apiResponse = new ApiResponse("Success", "Data Found", addressResponse);
        return ResponseEntity.status(200).body(apiResponse);
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAll(){
        List<AddressResponse> addressResponses = addressService.findAllAddress();
        ApiResponse apiResponse = new ApiResponse("Success", "Data Found", addressResponses);
        return ResponseEntity.status(200).body(apiResponse);
    }


    @GetMapping("/all-address-by-userId/{userId}")
    public ResponseEntity<ApiResponse> getAllAddressOfUserByUserId(@PathVariable Long userId){
        List<AddressResponse> addressResponses = addressService.findAddressOfUserByUserId(userId);
        ApiResponse apiResponse = new ApiResponse("Success", "Data Found", addressResponses);
        return ResponseEntity.status(200).body(apiResponse);
    }
    @GetMapping("/all-address-by-email/{email}")
    public ResponseEntity<ApiResponse> getAllAddressOfAUser(@PathVariable String email){
        List<AddressResponse> addressResponses = addressService.findAddressOfUserByEmail(email);
        ApiResponse apiResponse = new ApiResponse("Success", "Data Found", addressResponses);
        return ResponseEntity.status(200).body(apiResponse);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteAddress(@PathVariable Long id){
        AddressResponse addressResponse = addressService.deleteAddress(id);
        ApiResponse apiResponse = new ApiResponse("Success", "Data Found", addressResponse);
        return ResponseEntity.status(200).body(apiResponse);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateAddress(@PathVariable Long id, @RequestBody AddressRequest addressRequest){
        AddressResponse addressResponse = addressService.updateAddress(id,addressRequest);
        ApiResponse apiResponse = new ApiResponse("Success", "Data Found", addressResponse);
        return ResponseEntity.status(200).body(apiResponse);
    }
}
