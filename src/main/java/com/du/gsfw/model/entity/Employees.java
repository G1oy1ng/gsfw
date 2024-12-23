package com.du.gsfw.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
@Table(name = "Employees")
public class Employees extends BaseEntity{
    @Column(name = "employeeId")
    private Integer id;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "birthDate")
    private String birthDate;
    @Column(name = "photo")
    private String photo;
    @Column(name = "notes")
    private String notes;
}
