package com.shekhar.ecommerce.application.service.impl;

import com.shekhar.ecommerce.application.dto.requestDto.ProductRequest;
import com.shekhar.ecommerce.application.dto.responseDto.ProductResponse;
import com.shekhar.ecommerce.application.mapper.ProductMapper;
import com.shekhar.ecommerce.application.model.Category;
import com.shekhar.ecommerce.application.model.Product;
import com.shekhar.ecommerce.application.repository.CategoryRepository;
import com.shekhar.ecommerce.application.repository.ProductRepository;
import com.shekhar.ecommerce.application.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductResponse addProduct(ProductRequest productRequest) {
//        Product product = modelMapper.map(productRequest, Product.class);
//        productRepository.save(product);
        Product product = productMapper.mapProductRequestToProduct(productRequest);
        productRepository.save(product);
        return productMapper.mapProductToProductResponse(product);
    }

    @Override
    public Product findProduct(Long id) {
        return productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not found with id: "+ id));
    }

    @Override
    public ProductResponse findProductById(Long id) {
        Product product = findProduct(id);
//        return modelMapper.map(product, ProductResponse.class);
        return productMapper.mapProductToProductResponse(product);
    }

    @Override
    public List<ProductResponse> findAllProducts() {
        List<Product> products = productRepository.findAll();
//        return modelMapper.map(products, List.class);  // It will return of type List<> only
//        List<ProductResponse> productResponses = products.stream().
//                map(product -> modelMapper.map(product, ProductResponse.class)).toList(); //
        List<ProductResponse> productResponses = productMapper.mapProductsToProductResponses(products);
        return productResponses;
    }

    @Override
    public List<ProductResponse> findAllProductsInCategory(Long categoryId) {
        List<Product> products = productRepository.findByCategoryId(categoryId);
        return productMapper.mapProductsToProductResponses(products);
    }

    @Override
    public ProductResponse updateProduct(Long id, ProductRequest productDto) {
        return null;
    }

    @Override
    public ProductResponse deleteProduct(Long id) {
        Product product = findProduct(id);
        productRepository.delete(product);
        return productMapper.mapProductToProductResponse(product);
    }
}
