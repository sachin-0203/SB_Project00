package com.minor.Project.services;

import com.minor.Project.dto.ProductDto;

import java.util.List;

public interface ProductService {
  List<ProductDto> getAllProduct();
  ProductDto getProductById(Long id);
  ProductDto createProduct(ProductDto product);
  ProductDto updateProduct(ProductDto product);
  ProductDto deleteProduct(Long id);
}
