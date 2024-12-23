package com.du.gsfw.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.du.gsfw.model.entity.Employees;


import java.util.List;

public interface EmployeeService extends IService<Employees> {
    boolean creat(Employees employees);

    boolean update(Employees employees);

    void delete(Long id);

    Employees findById(Long id);
    List<Employees> selectByLikeLastName(String lastName);
    List<Employees> selectByLikeFirstName(String firstName);
    List<Employees> selectByLikeLastNameAndFirstName(String lastName,String firstName);
    List<Employees> selectByLikeBirthDate(String birthDate);

    List<Employees> selectAll();


}
