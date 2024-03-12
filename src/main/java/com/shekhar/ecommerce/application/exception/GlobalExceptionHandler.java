package com.shekhar.ecommerce.application.exception;

import com.shekhar.ecommerce.application.customresponse.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ApiResponse handleGenericException(Exception ex){
        return new ApiResponse("error", ex.getMessage(), null);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse handleNotFoundException(NotFoundException ex){
        return new ApiResponse("error", ex.getMessage(), null);
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse handleBadRequestException(BadRequestException ex){
        return new ApiResponse("error", ex.getMessage(), null);
    }
}
