package com.minor.Project.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.minor.Project.services.ProductServiceImp;

import jakarta.validation.Valid;

import com.minor.Project.dto.ProductDto;
import com.minor.Project.exception.ResourceNotFoundException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/products")
public class ProductController {

  private final ProductServiceImp productServiceImp;

  public ProductController(ProductServiceImp productServiceImp){
    this.productServiceImp = productServiceImp;
  } 
  
  @GetMapping
  public ResponseEntity<List<ProductDto>> getAllProduct() {
    return ResponseEntity.ok(productServiceImp.getAllProduct());
  }

  @PostMapping
  public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto product) {
    productServiceImp.createProduct(product);
    return ResponseEntity.status(HttpStatus.CREATED).body(product);
  }
  
  @PutMapping
  public ResponseEntity<ProductDto> updateProduct (@Valid @RequestBody ProductDto product) {
    productServiceImp.updateProduct(product);
    return ResponseEntity.ok(product);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
    if(productServiceImp.getProductById(id) == null){
      throw new ResourceNotFoundException("The Product is not found");
    }
    return ResponseEntity.ok(productServiceImp.getProductById(id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteProduct(@PathVariable Long id){
    ProductDto deleted = productServiceImp.deleteProduct(id);
    if(deleted == null){
      throw new ResourceNotFoundException("No Product found to delete");
    }
    return ResponseEntity.ok(deleted);
  }

}
