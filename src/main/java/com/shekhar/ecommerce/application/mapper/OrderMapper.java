package com.shekhar.ecommerce.application.mapper;

import com.shekhar.ecommerce.application.dto.requestDto.OrderRequest;
import com.shekhar.ecommerce.application.dto.responseDto.OrderResponse;
import com.shekhar.ecommerce.application.model.Cart;
import com.shekhar.ecommerce.application.model.OrderEntity;
import com.shekhar.ecommerce.application.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {

    OrderEntity mapOrderRequestToOrder(OrderRequest orderRequest);

    @Mappings({
            @Mapping(source = "cart.id", target = "cartId"),
            @Mapping(source = "user.id", target = "userId")
    })
    OrderResponse mapOrderToOrderResponse(OrderEntity orderEntity);
    List<OrderEntity> mapOrderRequestsToOrders(List<OrderRequest> orderRequests);
    List<OrderResponse> mapOrdersToOrderResponses(List<OrderEntity> orderEntities);

    default Long map(Cart cart){
        return cart.getId();
    }
    default Long map(User user){
        return user.getId();
    }
}
