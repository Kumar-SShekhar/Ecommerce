package com.shekhar.ecommerce.application.dto.requestDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class UserRequest {

    @NotNull
    private String name;

    @Email
    private String email;

    @NotNull
    private Integer age;

    @Pattern(regexp = "[6-9]\\d{9}")
    private String phoneNumber;

    @NotNull
    private String password;

}
