package com.shekhar.ecommerce.application.service.impl;

import com.shekhar.ecommerce.application.dto.requestDto.UserRequest;
import com.shekhar.ecommerce.application.model.User;
import com.shekhar.ecommerce.application.repository.UserRepository;
import com.shekhar.ecommerce.application.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserRequest createUser(UserRequest userRequest) {
//        User user = new User();
//        user.setName(userRequest.getName());
//        user.setAge(user.getAge());
//        user.setEmail(userRequest.getEmail());
//        user.setPassword(userRequest.getPassword());
//        user.setPhoneNumber(userRequest.getPhoneNumber());
        User user = modelMapper.map(userRequest, User.class);
        userRepository.save(user);
        return userRequest;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, UserRequest userRequest) {
        return null;

    }

    @Override
    public User deleteUser(Long id) {
        return null;
    }
}
