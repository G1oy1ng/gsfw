package com.du.gsfw.model.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class OrdersDetailsOrdersDto {
    private Integer orderDetailId;
    private Integer orderId;
    private Integer productId;
    private Integer quantity;
    private Integer customerId;
    private Integer employeeId;
    private String orderDate;
    private String shipperId;
}
