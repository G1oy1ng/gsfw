package com.du.gsfw.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.du.gsfw.mapper.OrderDetailMapper;
import com.du.gsfw.model.dto.OrdersDetailsOrdersDto;
import com.du.gsfw.model.dto.OrdersDetailsProductsDto;
import com.du.gsfw.model.entity.OrderDetails;
import com.du.gsfw.service.OrderDetailService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper,OrderDetails> implements OrderDetailService{
    @Override
    public boolean create(OrderDetails orderDetails) {
        return save(orderDetails);
    }

    @Override
    public boolean update(OrderDetails orderDetails) {
        return updateById(orderDetails);
    }

    @Override
    public void delete(Long id) {
        removeById(id);
    }

    @Override
    public OrderDetails findById(Long id) {
        return getById(id);
    }

    @Override
    public List<OrderDetails> selectAll() {
        return baseMapper.selectList(null);
    }

    @Override
    public List<OrdersDetailsOrdersDto> findByOrderId(Long orderId) {
        return baseMapper.findByOrderId(orderId);
    }

    @Override
    public List<OrdersDetailsProductsDto> findByProductId(Long produceId) {
        return baseMapper.findByProductId(produceId);
    }
}
