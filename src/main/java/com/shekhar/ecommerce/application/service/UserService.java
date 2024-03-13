package com.shekhar.ecommerce.application.service;

import com.shekhar.ecommerce.application.dto.requestDto.UserRequest;
import com.shekhar.ecommerce.application.dto.responseDto.UserResponse;
import com.shekhar.ecommerce.application.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public UserResponse createUser(UserRequest userRequest);
    public List<UserResponse> findAllUsers();
    public UserResponse updateUser(Long id, UserRequest userRequest);
    public UserResponse deleteUser(Long id);
}
