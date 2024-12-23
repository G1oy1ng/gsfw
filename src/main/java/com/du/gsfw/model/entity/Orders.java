package com.du.gsfw.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
@Table(name = "Orders")
public class Orders extends BaseEntity{
    @Column(name = "orderId")
    private Integer id;
    @Column(name = "customerId")
    private Integer customerId;
    @Column(name = "employeeId")
    private Integer employeeId;
    @Column(name = "orderDate")
    private String orderDate;
    @Column(name = "shipperId")
    private String shipperId;
}
