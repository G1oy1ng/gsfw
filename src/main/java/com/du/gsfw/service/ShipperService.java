package com.du.gsfw.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.du.gsfw.model.entity.Shippers;

import java.util.List;

public interface ShipperService extends IService<Shippers> {
    boolean creat(Shippers shippers);
    void delete(Long id);
    boolean update(Shippers shippers);
    Shippers findById(Long id);
    List<Shippers> selectAll();
    List<Shippers> selectByShipperNameLike(String shipperName);
    List<Shippers> selectByShipperPhoneLike(String phone);
}
