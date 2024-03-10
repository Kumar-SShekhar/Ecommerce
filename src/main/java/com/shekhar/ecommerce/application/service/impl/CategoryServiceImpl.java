package com.shekhar.ecommerce.application.service.impl;

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

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category findCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category not found with id: "+ id));
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        return null;
    }

    @Override
    public Category deleteCategory(Long id) {
        Category category = findCategoryById(id);
        categoryRepository.delete(category);
        return category;
    }
}
