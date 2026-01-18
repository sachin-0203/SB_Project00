package com.minor.Project.services;

import com.minor.Project.dto.ProductDto;

import java.util.*;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImp implements ProductService {

  Map<Long, ProductDto> productMap = new HashMap<>();

  
  @Override
  public List<ProductDto> getAllProduct(){
    List<ProductDto> productList = new ArrayList<>(productMap.values());
    return productList;
  }
  
  @Override
  public ProductDto getProductById(Long id){
    return productMap.get(id);
  }

  @Override
  public ProductDto createProduct(ProductDto product){
    productMap.put(product.getId(), product);
    return product;
  }

  @Override
  public ProductDto updateProduct(ProductDto product){
    productMap.put(product.getId(), product);
    return product;
  }

  @Override
  public ProductDto deleteProduct(Long id){
    ProductDto removedP = productMap.remove(id);
    return removedP;
  }
}
