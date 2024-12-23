package com.du.gsfw.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.du.gsfw.model.dto.OrdersDetailsOrdersDto;
import com.du.gsfw.model.dto.OrdersDetailsProductsDto;
import com.du.gsfw.model.entity.OrderDetails;

import java.util.List;

public interface OrderDetailMapper extends BaseMapper<OrderDetails> {
    List<OrdersDetailsOrdersDto> findByOrderId(Long orderId);
    List<OrdersDetailsProductsDto> findByProductId(Long produceId);
}
