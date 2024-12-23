package com.du.gsfw.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.du.gsfw.mapper.CategoriesMapper;
import com.du.gsfw.model.entity.Categories;
import com.du.gsfw.service.CategoriesService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoriesServiceImpl extends ServiceImpl<CategoriesMapper, Categories> implements CategoriesService {
    @Override
    public Categories findById(Long id) {
        return getById(id);
    }

    @Override
    public List<Categories> findByLikeName(String name) {
        QueryWrapper<Categories> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("categoryName", name);
        List<Categories> categoriesList = baseMapper.selectList(queryWrapper);
        return categoriesList;
    }

    @Override
    public void delete(Long id) {
        removeById(id);
    }

    @Override
    public boolean update(Categories categories) {
        return updateById(categories);
    }

    @Override
    public boolean create(Categories categories) {
        return save(categories);
    }

    @Override
    public List<Categories> selectAll() {
        return baseMapper.selectList(null);
    }
}
