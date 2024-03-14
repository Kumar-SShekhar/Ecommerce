package com.shekhar.ecommerce.application.mapper;

import ch.qos.logback.core.model.ModelConstants;
import com.shekhar.ecommerce.application.dto.requestDto.AddressRequest;
import com.shekhar.ecommerce.application.dto.responseDto.AddressResponse;
import com.shekhar.ecommerce.application.model.Address;
import com.shekhar.ecommerce.application.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AddressMapper {

    Address mapAddressRequestToAddress(AddressRequest addressRequest);

    @Mapping(source = "user.id" , target = "userId")
    AddressResponse mapAddressToAddressResponse(Address address);

    List<AddressResponse> mapAddressesToAddressResponses(List<Address> addresses);

    default Long map(User user){
        return user.getId();
    }
}
