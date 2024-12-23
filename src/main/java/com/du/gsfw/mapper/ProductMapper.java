package com.du.gsfw.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.du.gsfw.model.dto.ProductsCategoriesDto;
import com.du.gsfw.model.dto.ProductsSuppliersDto;
import com.du.gsfw.model.entity.Products;

import java.util.List;

public interface ProductMapper extends BaseMapper<Products> {
    List<ProductsCategoriesDto> findByCategoryId(Long categoryId);
    List<ProductsSuppliersDto> findBysSupplierId(Long supplierId);
}
