package com.shekhar.ecommerce.application.controller;

import com.shekhar.ecommerce.application.dto.requestDto.ProductRequest;
import com.shekhar.ecommerce.application.dto.responseDto.ProductResponse;
import com.shekhar.ecommerce.application.service.ProductService;
import jakarta.persistence.Lob;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.naming.LinkLoopException;
import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/new")
    public ProductResponse addNewProduct(@RequestBody ProductRequest productRequest){
        return productService.addProduct(productRequest);
    }

    @GetMapping("/all")
    public List<ProductResponse> getAllProducts(){
        return productService.findAllProducts();
    }

    @GetMapping("/id/{id}")
    public ProductResponse getProductById(@PathVariable Long id){
        return productService.findProductById(id);
    }


    @GetMapping("/all-products-in-category/{categoryId}")
    public List<ProductResponse> getAllProductsInCategory(@PathVariable Long categoryId){
        return productService.findAllProductsInCategory(categoryId);
    }

    @PutMapping("/update/{id}")
    public  ProductResponse updateProduct(@PathVariable Long id, @RequestBody ProductRequest productRequest){
        return productService.updateProduct(id, productRequest);
    }

    @DeleteMapping("/delete/{id}")
    public ProductResponse deleteProduct(@PathVariable Long id){
        return productService.deleteProduct(id);
    }

}
