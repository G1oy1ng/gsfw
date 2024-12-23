package com.du.gsfw.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.du.gsfw.model.dto.OrdersCustomersDto;
import com.du.gsfw.model.dto.OrdersEmployeesDto;
import com.du.gsfw.model.dto.OrdersShippersDto;
import com.du.gsfw.model.entity.Orders;

import java.util.List;

public interface OrderMapper extends BaseMapper<Orders> {
    List<OrdersCustomersDto> findByCustomerId(Long customerId);
    List<OrdersEmployeesDto> findByEmployeeId(Long employeeId);
    List<OrdersShippersDto> findByShipperId(Long shipperId);
}
