package com.shekhar.ecommerce.application.mapper;

import ch.qos.logback.core.model.ModelConstants;
import com.shekhar.ecommerce.application.dto.requestDto.UserRequest;
import com.shekhar.ecommerce.application.dto.responseDto.UserResponse;
import com.shekhar.ecommerce.application.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    User mapUserRequestToUser(UserRequest userRequest);
    UserResponse mapUserToUserResponse(User user);

    List<UserRequest> mapUserRequestsToUser(List<UserRequest> userRequests);
    List<UserResponse> mapUsersToUserResponses(List<User> users);
}
