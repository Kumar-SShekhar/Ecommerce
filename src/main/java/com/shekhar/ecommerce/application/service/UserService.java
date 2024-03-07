package com.shekhar.ecommerce.application.service;

import com.shekhar.ecommerce.application.dto.requestDto.UserRequest;
import com.shekhar.ecommerce.application.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public UserRequest createUser(UserRequest userRequest);
    public List<User> findAllUsers();
    public User updateUser(Long id, UserRequest userRequest);
    public User deleteUser(Long id);
}
