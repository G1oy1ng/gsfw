package com.du.gsfw.model.dto;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class OrdersDetailsProductsDto {
    private Integer orderDetailId;
    private Integer orderId;
    private Integer productId;
    private Integer quantity;
    private String productName;
    private Integer supplierId;
    private Integer categoryId;
    private String unit;
    private Double price;
}
