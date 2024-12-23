package com.du.gsfw.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
@Table(name = "Shippers")
public class Shippers extends BaseEntity{
    @Column(name = "shipperId")
    private Integer id;
    @Column(name = "shipperName")
    private String shipperName;
    @Column(name = "phone")
    private String phone;
}
