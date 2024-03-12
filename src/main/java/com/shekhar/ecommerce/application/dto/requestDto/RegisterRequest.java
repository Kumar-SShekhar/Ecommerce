package com.shekhar.ecommerce.application.dto.requestDto;

import lombok.Getter;

@Getter
public class RegisterRequest {


    private String name;
    private String email;
    private Integer age;
    private String phoneNumber;
    private String password;
}
