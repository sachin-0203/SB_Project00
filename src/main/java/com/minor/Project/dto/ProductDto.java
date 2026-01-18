package com.minor.Project.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;


@Data
public class ProductDto {
  
  private Long id;
  
  @NotBlank(message = "Please add Product name")
  private String name;
  
  @NotNull(message = "Please add Product price")
  private Double price;

  @NotNull(message = "Please provide Stock is available or not")
  private Boolean isStock; 

  public Long getId(){
    return id;
  }
  public void setId(Long id){
    this.id = id;
  }

  public String getName(){
    return name;
  }
  public void setName(String name){
    this.name = name;
  }

  public Double getPrice(){
    return price;
  }
  public void setPrice(Double price){
    this.price = price;
  }

  public Boolean getIsStock(){
    return isStock;
  }
  public void setIsStock(Boolean isStock){
    this.isStock = isStock;
  }

}
