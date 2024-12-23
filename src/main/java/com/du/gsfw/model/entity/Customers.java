package com.du.gsfw.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
@Table(name = "Customers")
public class Customers extends BaseEntity{
    @Column(name = "customerId")
    private Integer id;
    @Column(name = "customerName")
    private String customerName;
    @Column(name = "contactName")
    private String contactName;
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "postalCode")
    private String postalCode;
    @Column(name = "country")
    private String country;
}
