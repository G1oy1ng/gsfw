package com.du.gsfw.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.du.gsfw.mapper.ShipperMapper;
import com.du.gsfw.model.entity.Shippers;
import com.du.gsfw.service.ShipperService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipperServiceImpl extends ServiceImpl<ShipperMapper, Shippers> implements ShipperService{
    @Override
    public boolean creat(Shippers shippers) {
        return save(shippers);
    }

    @Override
    public void delete(Long id) {
       removeById(id);
    }

    @Override
    public boolean update(Shippers shippers) {
        return updateById(shippers);
    }

    @Override
    public Shippers findById(Long id) {
        return getById(id);
    }

    @Override
    public List<Shippers> selectAll() {
        List<Shippers> shippers = baseMapper.selectList(null);
        return shippers;
    }

    @Override
    public List<Shippers> selectByShipperNameLike(String shipperName) {
        return baseMapper.selectList(new QueryWrapper<Shippers>().like("ShipperName", shipperName));
    }

    @Override
    public List<Shippers> selectByShipperPhoneLike(String phone) {
        return baseMapper.selectList(new QueryWrapper<Shippers>().like("Phone", phone));
    }
}
