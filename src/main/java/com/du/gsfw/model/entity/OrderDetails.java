package com.du.gsfw.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
@Table(name = "Orderdetails")
public class OrderDetails extends BaseEntity{
    @Column(name = "orderDetailId")
    private Integer id;
    @Column(name = "orderId")
    private Integer orderId;
    @Column(name = "productId")
    private Integer productId;
    @Column(name = "quantity")
    private Integer quantity;
}
