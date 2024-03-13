package com.shekhar.ecommerce.application.mapper;

import com.shekhar.ecommerce.application.dto.requestDto.ProductRequest;
import com.shekhar.ecommerce.application.dto.responseDto.ProductResponse;
import com.shekhar.ecommerce.application.model.Category;
import com.shekhar.ecommerce.application.model.Product;
import com.shekhar.ecommerce.application.model.Seller;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {


    Product mapProductRequestToProduct(ProductRequest productRequest);


    @Mappings({
            @Mapping(source = "category.id", target = "categoryId"),
            @Mapping(source = "seller.id" , target = "sellerId")
    })
    ProductResponse mapProductToProductResponse(Product product);
    default Long map(Category category) {  // We have "category" field of type Category in product entity but "categoryId" field of type Long in ProductResponse . This method maps them accordingly
        return category.getId();
    }
    default Long map(Seller seller) {
        return seller.getId();
    }

/*    default Long mapToId(Object object) {       // We can write in a single method
        if (object instanceof Category) {
            return ((Category) object).getId();
        } else if (object instanceof Seller) {
            return ((Seller) object).getId();
        } else {
            throw new IllegalArgumentException("Unsupported type: " + object.getClass());
        }
    } */


    List<Product> mapProductRequestsToProducts(List<ProductRequest> productRequests);
    List<ProductResponse> mapProductsToProductResponses(List<Product> products);
}
