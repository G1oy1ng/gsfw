package com.du.gsfw.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.du.gsfw.model.dto.OrdersCustomersDto;
import com.du.gsfw.model.dto.OrdersEmployeesDto;
import com.du.gsfw.model.dto.OrdersShippersDto;
import com.du.gsfw.model.entity.Orders;

import java.util.List;

public interface OrderService extends IService<Orders> {
    List<Orders> selectAll();
    boolean create(Orders orders);
    boolean update(Orders orders);
    void delete(Long id);
    Orders findById(Long id);
    List<OrdersCustomersDto> findByCustomerId(Long customerId);
    List<OrdersEmployeesDto> findByEmployeeId(Long employeeId);
    List<OrdersShippersDto> findByShipperId(Long shipperId);
    List<Orders> findByOrderDate(String orderDate);
}
