package com.du.gsfw.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
@Table(name = "Products")
public class Products extends BaseEntity{
    @Column(name = "productId")
    private Integer id;
    @Column(name = "productName")
    private String productName;
    @Column(name = "supplierId")
    private Integer supplierId;
    @Column(name = "categoryId")
    private Integer categoryId;
    @Column(name = "unit")
    private String unit;
    @Column(name = "price")
    private Double price;
}
