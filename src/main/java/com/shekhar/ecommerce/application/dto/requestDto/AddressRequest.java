package com.shekhar.ecommerce.application.dto.requestDto;

import com.shekhar.ecommerce.application.model.User;
import lombok.Getter;

@Getter
public class AddressRequest {

    private String name;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String postalCode;
    private String state;
    private String phoneNumber;
    private User user;
}
