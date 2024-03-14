package com.shekhar.ecommerce.application.controller;

import com.shekhar.ecommerce.application.customresponse.ApiResponse;
import com.shekhar.ecommerce.application.dto.requestDto.ProductRequest;
import com.shekhar.ecommerce.application.dto.responseDto.ProductResponse;
import com.shekhar.ecommerce.application.service.ProductService;
import jakarta.persistence.Lob;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.LinkLoopException;
import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/new")
    public ResponseEntity<ApiResponse> addNewProduct(@RequestBody ProductRequest productRequest){
        ProductResponse productResponse = productService.addProduct(productRequest);
        ApiResponse apiResponse = new ApiResponse("Success", "Data Found", productResponse);
        return ResponseEntity.status(200).body(apiResponse);
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllProducts(){
        List<ProductResponse> productResponses = productService.findAllProducts();
        ApiResponse apiResponse = new ApiResponse("Success", "Data Found", productResponses);
        return ResponseEntity.status(200).body(apiResponse);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ApiResponse> getProductById(@PathVariable Long id){
        ProductResponse productResponse = productService.findProductById(id);
        ApiResponse apiResponse = new ApiResponse("Success", "Data Found", productResponse);
        return ResponseEntity.status(200).body(apiResponse);
    }


    @GetMapping("/all-products-in-category/{categoryId}")
    public ResponseEntity<ApiResponse> getAllProductsInCategory(@PathVariable Long categoryId){
        List<ProductResponse> productResponses = productService.findAllProductsInCategory(categoryId);
        ApiResponse apiResponse = new ApiResponse("Success", "Data Found", productResponses);
        return ResponseEntity.status(200).body(apiResponse);
    }

    @PutMapping("/update/{id}")
    public  ResponseEntity<ApiResponse> updateProduct(@PathVariable Long id, @RequestBody ProductRequest productRequest){
        ProductResponse productResponse = productService.updateProduct(id, productRequest);
        ApiResponse apiResponse = new ApiResponse("Success", "Data Found", productResponse);
        return ResponseEntity.status(200).body(apiResponse);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Long id){
        ProductResponse productResponse = productService.deleteProduct(id);
        ApiResponse apiResponse = new ApiResponse("Success", "Data Found", productResponse);
        return ResponseEntity.status(200).body(apiResponse);
    }

//    public ResponseEntity<ApiResponse> apiResponseResponseEntity(Object data){
//        return ResponseEntity.status(200).body(new ApiResponse("Success", "Data Found", data));
//    }

}
