package com.du.gsfw.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.du.gsfw.mapper.SupplierMapper;
import com.du.gsfw.model.entity.Suppliers;
import com.du.gsfw.service.SupplierService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl extends ServiceImpl<SupplierMapper, Suppliers> implements SupplierService {
    @Override
    public void delete(Long id) {
        removeById(id);
    }

    @Override
    public Suppliers findById(Long id) {
        return getById(id);
    }

    @Override
    public boolean update(Suppliers suppliers) {
        return updateById(suppliers);
    }

    @Override
    public boolean create(Suppliers suppliers) {
        return save(suppliers);
    }

    @Override
    public List<Suppliers> selectAll() {
        List<Suppliers> suppliers = baseMapper.selectList(null);
        return suppliers;
    }

    @Override
    public List<Suppliers> findByLikeSupplierName(String supplierName) {
        return baseMapper.selectList(new QueryWrapper<Suppliers>().like("SupplierName", supplierName));
    }

    @Override
    public List<Suppliers> findByLikeContactName(String contactName) {
        return baseMapper.selectList(new QueryWrapper<Suppliers>().like("ContactName", contactName));
    }

    @Override
    public List<Suppliers> findByLikeAddress(String address) {
        return baseMapper.selectList(new QueryWrapper<Suppliers>().like("Address", address));
    }

    @Override
    public List<Suppliers> findByLikeCity(String city) {
        return baseMapper.selectList(new QueryWrapper<Suppliers>().like("City", city));
    }

    @Override
    public List<Suppliers> findByLikePostalCode(String postalCode) {
        return baseMapper.selectList(new QueryWrapper<Suppliers>().like("PostalCode", postalCode));
    }

    @Override
    public List<Suppliers> findByLikeCountry(String country) {
        return baseMapper.selectList(new QueryWrapper<Suppliers>().like("Country", country));
    }

    @Override
    public List<Suppliers> findByLikePhone(String phone) {
        return baseMapper.selectList(new QueryWrapper<Suppliers>().like("Phone", phone));
    }
}
