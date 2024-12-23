package com.du.gsfw.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.du.gsfw.model.dto.OrdersDetailsOrdersDto;
import com.du.gsfw.model.dto.OrdersDetailsProductsDto;
import com.du.gsfw.model.entity.OrderDetails;

import java.util.List;

public interface OrderDetailService extends IService<OrderDetails> {
    boolean create(OrderDetails orderDetails);
    boolean update(OrderDetails orderDetails);
    void delete(Long id);
    OrderDetails findById(Long id);
    List<OrderDetails> selectAll();
    List<OrdersDetailsOrdersDto> findByOrderId(Long orderId);
    List<OrdersDetailsProductsDto> findByProductId(Long produceId);

}
