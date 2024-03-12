package com.shekhar.ecommerce.application.customresponse;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiResponse {

    private String status;
    private String message;
    private Object data;
}
