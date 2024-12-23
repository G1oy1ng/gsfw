package com.du.gsfw.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.du.gsfw.model.entity.Suppliers;

import java.util.List;

public interface SupplierService extends IService<Suppliers> {
    void delete(Long id);
    Suppliers findById(Long id);
    boolean update(Suppliers suppliers);
    boolean create(Suppliers suppliers);

    List<Suppliers> selectAll();
    List<Suppliers> findByLikeSupplierName(String supplierName);
    List<Suppliers> findByLikeContactName(String contactName);
    List<Suppliers> findByLikeAddress(String address);
    List<Suppliers> findByLikeCity(String city);
    List<Suppliers> findByLikePostalCode(String postalCode);
    List<Suppliers> findByLikeCountry(String country);
    List<Suppliers> findByLikePhone(String phone);
}
