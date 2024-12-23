package com.du.gsfw.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.du.gsfw.mapper.CustomerMapper;

import com.du.gsfw.model.entity.Customers;
import com.du.gsfw.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customers> implements CustomerService {
    @Override
    public void delete(Long id) {
       removeById(id);
    }

    @Override
    public Customers findById(Long id) {
        return getById(id);
    }

    @Override
    public List<Customers> findByLikeCustomerName(String customerName) {
        QueryWrapper<Customers> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("customerName", customerName);
        List<Customers> customersList = baseMapper.selectList(queryWrapper);
        return customersList;
    }

    @Override
    public boolean update(Customers customers) {
        return updateById(customers);
    }

    @Override
    public boolean create(Customers customers) {
        return save(customers);
    }

    @Override
    public List<Customers> selectAll() {
        List<Customers> customers = baseMapper.selectList(null);
        return customers;
    }
}
