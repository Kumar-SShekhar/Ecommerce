package com.shekhar.ecommerce.application.service.impl;

import com.shekhar.ecommerce.application.dto.requestDto.UserRequest;
import com.shekhar.ecommerce.application.dto.responseDto.UserResponse;
import com.shekhar.ecommerce.application.mapper.UserMapper;
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
    private final UserMapper userMapper;

    @Override
    public UserResponse createUser(UserRequest userRequest) {
//        User user = new User();
//        user.setName(userRequest.getName());
//        user.setAge(user.getAge());
//        user.setEmail(userRequest.getEmail());
//        user.setPassword(userRequest.getPassword());
//        user.setPhoneNumber(userRequest.getPhoneNumber());

//        User user = modelMapper.map(userRequest, User.class);

        User user = userMapper.mapUserRequestToUser(userRequest);
        userRepository.save(user);
        return userMapper.mapUserToUserResponse(user);
    }

    @Override
    public List<UserResponse> findAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.mapUsersToUserResponses(users);
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest userRequest) {
        return null;

    }

    @Override
    public UserResponse deleteUser(Long id) {
        return null;
    }
}
