package com.shekhar.ecommerce.application.service;

import com.shekhar.ecommerce.application.dto.requestDto.ProductRequest;
import com.shekhar.ecommerce.application.dto.responseDto.ProductResponse;
import com.shekhar.ecommerce.application.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    public ProductResponse addProduct(ProductRequest productRequest);
    public Product findProduct(Long id);
    public ProductResponse findProductById(Long id);
    public List<ProductResponse> findAllProducts();
    public List<ProductResponse> findAllProductsInCategory(Long categoryId);
    public ProductResponse updateProduct(Long id, ProductRequest productRequest);
    public ProductResponse deleteProduct(Long id);
}
