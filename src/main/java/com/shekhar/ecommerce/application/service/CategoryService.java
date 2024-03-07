package com.shekhar.ecommerce.application.service;

import com.shekhar.ecommerce.application.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    public Category addCategory(Category category);
    public List<Category> findAllCategory();
    public Category updateCategory(Long id, Category category);
    public Category deleteCategory(Long id);
}
