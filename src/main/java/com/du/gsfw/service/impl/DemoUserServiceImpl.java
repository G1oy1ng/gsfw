package com.du.gsfw.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.du.gsfw.convert.DemoUserConvert;
import com.du.gsfw.exception.IncorrectParameterException;
import com.du.gsfw.mapper.DemoUserMapper;
import com.du.gsfw.model.dto.base.IPageModel;
import com.du.gsfw.model.dto.request.DemoUserAddRequestDTO;
import com.du.gsfw.model.dto.request.DemoUserLoginRequestDTO;
import com.du.gsfw.model.dto.request.DemoUserPageRequestDTO;
import com.du.gsfw.model.dto.request.DemoUserUpdateRequestDTO;
import com.du.gsfw.model.dto.response.DemoUserResponseDTO;
import com.du.gsfw.model.entity.DemoUser;
import com.du.gsfw.service.DemoUserService;
import com.du.gsfw.utils.GsUtils;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(propagation = Propagation.SUPPORTS, transactionManager = "transactionManager" , readOnly = true, rollbackFor = Exception.class)
public class DemoUserServiceImpl extends ServiceImpl<DemoUserMapper,DemoUser> implements DemoUserService {

    @Resource
    private DemoUserConvert demoUserConvert;

    @Override
    public DemoUser findByUserName(String userName) {
        QueryWrapper<DemoUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userName);
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public DemoUser findByEmail(String email) {
        QueryWrapper<DemoUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("email", email);
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public DemoUser findByMobile(String mobile) {
        QueryWrapper<DemoUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("mobile", mobile);
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public DemoUser findByUserNameAndPassword(String userName, String password) {
        QueryWrapper<DemoUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userName).eq("password", password);
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public List<DemoUser> mobileLike(String mobile) {
       QueryWrapper<DemoUser> queryWrapper = new QueryWrapper<>();
       queryWrapper.like("mobile", mobile);
       return baseMapper.selectList(queryWrapper);
    }

    @Override
    public List<DemoUser> userNameLike(String userName) {
        QueryWrapper<DemoUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("username", userName);
        return baseMapper.selectList(queryWrapper);
    }


    @Override
    public Boolean create(DemoUserAddRequestDTO demoUserAddRequestDTO) {
        demoUserAddRequestDTO.setPassword(DigestUtils.md5DigestAsHex(demoUserAddRequestDTO.getPassword().getBytes()));
        return save(demoUserConvert.toEntity(demoUserAddRequestDTO));
    }

    @Override
    public void update(DemoUserUpdateRequestDTO demoUserUpdateRequestDTO) throws IncorrectParameterException {

        if (demoUserUpdateRequestDTO.getId() == null) {
            throw new IncorrectParameterException("id must not be null");
        }

        Optional<DemoUser> optional = Optional.ofNullable(getById(demoUserUpdateRequestDTO.getId()));
        if (optional.isPresent()) {
            DemoUser demoUser = optional.get();

            if (demoUserUpdateRequestDTO.getMobile() != null) {
                demoUser.setMobile(demoUserUpdateRequestDTO.getMobile());
            }
            if (demoUserUpdateRequestDTO.getEmail() != null) {
                demoUser.setEmail(demoUserUpdateRequestDTO.getEmail());
            }
            save(demoUser);
        } else {
            throw new IncorrectParameterException(
                    "update target User(id:" + String.valueOf(demoUserUpdateRequestDTO.getId()) + ") is not exist");
        }
    }

    @Override
    public void delete(Long id) {
        Optional<DemoUser> optionalNews = Optional.ofNullable(getById(id));
        if(optionalNews.isPresent()){
            DemoUser demoUser = optionalNews.get();
            demoUser.setDeleted(true);
            save(demoUser);
        }
    }

    @Override
    public IPageModel<DemoUserResponseDTO> list(DemoUserPageRequestDTO param) {
        QueryWrapper<DemoUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("mobile", param.getMobile()).like("username", param.getUserName());
        Page<DemoUser> demoUserPage = baseMapper.selectPage(new Page<>(param.getPage(), param.getRows()), queryWrapper);
        List<DemoUserResponseDTO> demoUserResponseDTOList = demoUserPage.getRecords().stream().map(entity -> demoUserConvert.toDto(entity)).collect(Collectors.toList());
        Page<DemoUserResponseDTO> demoUserResponseDTOPage = new Page<>(demoUserPage.getCurrent(), demoUserPage.getSize(), demoUserPage.getTotal());
        demoUserResponseDTOPage.setRecords(demoUserResponseDTOList);
        return GsUtils.pageConvert(demoUserResponseDTOPage);
    }

    @Override
    public DemoUserResponseDTO findById(Long id) {
        return demoUserConvert.toDto(getById(id));
    }

    @Override
    public DemoUser login(DemoUserLoginRequestDTO demoUserLoginRequestDTO) {
        return findByUserNameAndPassword(demoUserLoginRequestDTO.getUserName(), DigestUtils.md5DigestAsHex(demoUserLoginRequestDTO.getPassword().getBytes()));
    }

    @Override
    public void loginSuccess(DemoUser demoUser) {
        save(demoUser);
    }
}
