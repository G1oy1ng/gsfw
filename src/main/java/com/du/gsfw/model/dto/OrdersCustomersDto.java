package com.du.gsfw.model.dto;



import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class OrdersCustomersDto {
    private Integer orderId;
    private Integer customerId;
    private Integer employeeId;
    private String orderDate;
    private String shipperId;
    private String customerName;
    private String contactName;
    private String address;
    private String city;
    private String postalCode;
    private String country;
}
