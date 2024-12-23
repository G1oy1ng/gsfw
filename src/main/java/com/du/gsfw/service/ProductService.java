package com.du.gsfw.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.du.gsfw.model.dto.ProductsCategoriesDto;
import com.du.gsfw.model.dto.ProductsSuppliersDto;
import com.du.gsfw.model.entity.Products;

import java.util.List;

public interface ProductService extends IService<Products> {
    boolean create(Products products);
    boolean update(Products products);
    void delete(Long id);
    Products findById(Long id);
    List<Products> selectAll();
    List<ProductsCategoriesDto> findByCategoryId(Long categoryId);
    List<ProductsSuppliersDto> findBysSupplierId(Long supplierId);
}
