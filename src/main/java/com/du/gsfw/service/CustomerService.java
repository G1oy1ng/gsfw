package com.du.gsfw.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.du.gsfw.model.entity.Customers;

import java.util.List;

public interface CustomerService extends IService<Customers> {

    void delete(Long id);

    Customers findById(Long id);

    List<Customers> findByLikeCustomerName(String customerName);

    boolean update(Customers customers) ;

    boolean create(Customers customers);

    List<Customers> selectAll();
}
