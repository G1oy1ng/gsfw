package com.du.gsfw.model.dto;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProductsCategoriesDto {
    private Integer productId;
    private String productName;
    private Integer supplierId;
    private Integer categoryId;
    private String unit;
    private Double price;
    private String categoryName;
    private String description;
}
