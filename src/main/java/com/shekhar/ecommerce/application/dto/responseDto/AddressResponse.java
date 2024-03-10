package com.shekhar.ecommerce.application.dto.responseDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressResponse {

    private Long id;
    private String name;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String postalCode;
    private String state;
    private String phoneNumber;
}
