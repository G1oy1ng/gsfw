package com.du.gsfw.model.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProductsSuppliersDto {
    private Integer productId;
    private String productName;
    private Integer supplierId;
    private Integer categoryId;
    private String unit;
    private Double price;
    private String supplierName;
    private String contactName;
    private String address;
    private String city;
    private String postalCode;
    private String country;
    private String phone;
}
