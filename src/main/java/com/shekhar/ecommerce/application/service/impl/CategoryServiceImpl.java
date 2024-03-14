package com.shekhar.ecommerce.application.service.impl;

import com.shekhar.ecommerce.application.dto.requestDto.CategoryRequest;
import com.shekhar.ecommerce.application.dto.responseDto.CategoryResponse;
import com.shekhar.ecommerce.application.mapper.CategoryMapper;
import com.shekhar.ecommerce.application.model.Category;
import com.shekhar.ecommerce.application.repository.CategoryRepository;
import com.shekhar.ecommerce.application.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryResponse addCategory(CategoryRequest categoryRequest) {
        Category category =  categoryMapper.mapCategoryRequestToCategory(categoryRequest);
        categoryRepository.save(category);
        return categoryMapper.mapCategoryToCategoryResponse(category);
    }

    public Category findCategory(Long id){
        return categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category not Found with id: "+ id));
    }
    @Override
    public CategoryResponse findCategoryById(Long id) {
        Category category=categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category not found with id: "+ id));
        return categoryMapper.mapCategoryToCategoryResponse(category);
    }

    @Override
    public List<CategoryResponse> findAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        return categoryMapper.mapCategoriesToCategoryResponses(categories);
    }

    @Override
    public CategoryResponse updateCategory(Long id, CategoryRequest categoryRequest) {
        return null;
    }

    @Override
    public CategoryResponse deleteCategory(Long id) {
        Category category = findCategory(id);
        categoryRepository.delete(category);
        return categoryMapper.mapCategoryToCategoryResponse(category);
    }
}
