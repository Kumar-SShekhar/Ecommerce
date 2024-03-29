package com.shekhar.ecommerce.application.controller;

import com.shekhar.ecommerce.application.dto.requestDto.UserRequest;
import com.shekhar.ecommerce.application.dto.responseDto.UserResponse;
import com.shekhar.ecommerce.application.repository.UserRepository;
import com.shekhar.ecommerce.application.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @PostMapping("/add")
    public UserResponse addUser(@Valid @RequestBody UserRequest userRequest){
        return userService.createUser(userRequest);
    }

}
