package com.du.gsfw.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
@Table(name = "Categories")
public class Categories extends BaseEntity{
    @Column(name = "categorieId")
    private Integer id;
    @Column(name = "categoryName")
    private String categoryName;
    @Column(name = "description")
    private String description;
}
