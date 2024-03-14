package com.shekhar.ecommerce.application.mapper;

import com.shekhar.ecommerce.application.dto.requestDto.CategoryRequest;
import com.shekhar.ecommerce.application.dto.responseDto.CategoryResponse;
import com.shekhar.ecommerce.application.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {

    Category mapCategoryRequestToCategory(CategoryRequest categoryRequest);
    CategoryResponse mapCategoryToCategoryResponse(Category category);

    List<CategoryResponse> mapCategoriesToCategoryResponses(List<Category> categories);
}
