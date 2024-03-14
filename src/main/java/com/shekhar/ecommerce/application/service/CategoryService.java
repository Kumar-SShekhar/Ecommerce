package com.shekhar.ecommerce.application.service;

import com.shekhar.ecommerce.application.dto.requestDto.CategoryRequest;
import com.shekhar.ecommerce.application.dto.responseDto.CategoryResponse;
import com.shekhar.ecommerce.application.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    public CategoryResponse addCategory(CategoryRequest categoryRequest);
    public CategoryResponse findCategoryById(Long id);
    public List<CategoryResponse> findAllCategory();
    public CategoryResponse updateCategory(Long id, CategoryRequest categoryRequest);
    public CategoryResponse deleteCategory(Long id);
}
