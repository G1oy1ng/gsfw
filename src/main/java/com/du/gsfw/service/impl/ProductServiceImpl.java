package com.du.gsfw.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.du.gsfw.mapper.ProductMapper;
import com.du.gsfw.model.dto.ProductsCategoriesDto;
import com.du.gsfw.model.dto.ProductsSuppliersDto;

import com.du.gsfw.model.entity.Products;
import com.du.gsfw.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Products> implements ProductService{
    @Override
    public boolean create(Products products) {
        return false;
    }

    @Override
    public boolean update(Products products) {
        return false;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Products findById(Long id) {
        return null;
    }

    @Override
    public List<Products> selectAll() {
        return null;
    }

    @Override
    public List<ProductsCategoriesDto> findByCategoryId(Long categoryId) {
        return baseMapper.findByCategoryId(categoryId);

    }

    @Override
    public List<ProductsSuppliersDto> findBysSupplierId(Long supplierId) {
        return baseMapper.findBysSupplierId(supplierId);

    }
}
