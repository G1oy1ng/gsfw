package com.du.gsfw.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.du.gsfw.mapper.EmployeeMapper;
import com.du.gsfw.model.entity.Employees;
import com.du.gsfw.service.EmployeeService;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employees> implements EmployeeService {
    @Override
    public boolean creat(Employees employees) {
        return save(employees);
    }

    @Override
    public boolean update(Employees employees) {
        return updateById(employees);
    }

    @Override
    public void delete(Long id) {
        removeById(id);
    }

    @Override
    public Employees findById(Long id) {
        return getById(id);
    }


    @Override
    public List<Employees> selectByLikeLastName(String lastName) {
        QueryWrapper<Employees> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("lastName", lastName);
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public List<Employees> selectByLikeFirstName(String firstName) {
        QueryWrapper<Employees> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("firstName", firstName);
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public List<Employees> selectByLikeLastNameAndFirstName(String lastName, String firstName) {
        QueryWrapper<Employees> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("lastName", lastName).like("firstName", firstName);
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public List<Employees> selectByLikeBirthDate(String birthDate) {
        QueryWrapper<Employees> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("birthDate", birthDate);
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public List<Employees> selectAll() {
        List<Employees> employees = baseMapper.selectList(null);
        return employees;
    }
}
