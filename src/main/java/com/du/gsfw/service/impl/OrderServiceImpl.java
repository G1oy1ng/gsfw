package com.du.gsfw.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.du.gsfw.mapper.OrderMapper;
import com.du.gsfw.model.dto.OrdersCustomersDto;
import com.du.gsfw.model.dto.OrdersEmployeesDto;
import com.du.gsfw.model.dto.OrdersShippersDto;
import com.du.gsfw.model.entity.Orders;
import com.du.gsfw.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Orders> implements OrderService {
    @Override
    public List<Orders> selectAll() {
        List<Orders> orders = baseMapper.selectList(null);
        return orders;
    }

    @Override
    public boolean create(Orders orders) {
        return save(orders);
    }

    @Override
    public boolean update(Orders orders) {
        return updateById(orders);
    }

    @Override
    public void delete(Long id) {
        removeById(id);
    }

    @Override
    public Orders findById(Long id) {
        return getById(id);
    }

    @Override
    public List<OrdersCustomersDto> findByCustomerId(Long customerId) {
        return baseMapper.findByCustomerId(customerId);
    }

    @Override
    public List<OrdersEmployeesDto> findByEmployeeId(Long employeeId) {
        return baseMapper.findByEmployeeId(employeeId);

    }

    @Override
    public List<OrdersShippersDto> findByShipperId(Long shipperId) {
        return baseMapper.findByShipperId(shipperId);

    }

    @Override
    public List<Orders> findByOrderDate(String orderDate) {
        return baseMapper.selectList(new QueryWrapper<Orders>().eq("OrderDate", orderDate));
    }
}
