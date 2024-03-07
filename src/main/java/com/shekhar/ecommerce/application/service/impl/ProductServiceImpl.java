package com.shekhar.ecommerce.application.service.impl;

import com.shekhar.ecommerce.application.dto.requestDto.ProductRequest;
import com.shekhar.ecommerce.application.model.Product;
import com.shekhar.ecommerce.application.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Product addProduct(ProductRequest productDto) {
        return null;
    }

    @Override
    public List<Product> findAllProducts() {
        return null;
    }

    @Override
    public Product updateProduct(Long id, ProductRequest productDto) {
        return null;
    }

    @Override
    public Product deleteProduct(Long id) {
        return null;
    }
}
