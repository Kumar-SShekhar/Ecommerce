package com.shekhar.ecommerce.application.controller;

import com.shekhar.ecommerce.application.customresponse.ApiResponse;
import com.shekhar.ecommerce.application.dto.requestDto.CategoryRequest;
import com.shekhar.ecommerce.application.dto.responseDto.CategoryResponse;
import com.shekhar.ecommerce.application.model.Category;
import com.shekhar.ecommerce.application.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/new")
    public ResponseEntity<ApiResponse> addCategory(@RequestBody CategoryRequest categoryRequest){
        CategoryResponse categoryResponse = categoryService.addCategory(categoryRequest);
        ApiResponse apiResponse = new ApiResponse("Success", "Data Found", categoryResponse);
        return ResponseEntity.status(200).body(apiResponse);
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllCategory(){
        List<CategoryResponse> categoryResponses = categoryService.findAllCategory();
        ApiResponse apiResponse = new ApiResponse("Success", "Data Found", categoryResponses);
        return ResponseEntity.status(200).body(apiResponse);
    }

    @GetMapping("/id")
    public ResponseEntity<ApiResponse> getCategoryById(@PathVariable Long id){
        CategoryResponse categoryResponse = categoryService.findCategoryById(id);
        ApiResponse apiResponse = new ApiResponse("Success", "Data Found", categoryResponse);
        return ResponseEntity.status(200).body(apiResponse);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateCategory(@PathVariable Long id, @RequestBody CategoryRequest categoryRequest){
        CategoryResponse categoryResponse = categoryService.updateCategory(id, categoryRequest);
        ApiResponse apiResponse = new ApiResponse("Success", "Data Found", categoryResponse);
        return ResponseEntity.status(200).body(apiResponse);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Long id){
        CategoryResponse categoryResponse = categoryService.deleteCategory(id);
        ApiResponse apiResponse = new ApiResponse("Success", "Data Found", categoryResponse);
        return ResponseEntity.status(200).body(apiResponse);
    }
}
