package com.du.gsfw.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.du.gsfw.model.entity.Categories;

import java.util.List;

public interface CategoriesService extends IService<Categories> {
    Categories findById(Long id);
    List<Categories> findByLikeName(String name);

    void delete(Long id);

    boolean update(Categories categories) ;

    boolean create(Categories categories);

    List<Categories> selectAll();
}
