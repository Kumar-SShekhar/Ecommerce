package com.shekhar.ecommerce.application.service;

import com.shekhar.ecommerce.application.dto.requestDto.ProductRequest;
import com.shekhar.ecommerce.application.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    public Product addProduct(ProductRequest productDto);
    public List<Product> findAllProducts();
    public Product updateProduct(Long id, ProductRequest productDto);
    public Product deleteProduct(Long id);
}
