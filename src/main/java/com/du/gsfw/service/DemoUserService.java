package com.du.gsfw.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.du.gsfw.exception.IncorrectParameterException;
import com.du.gsfw.model.dto.base.IPageModel;
import com.du.gsfw.model.dto.request.DemoUserAddRequestDTO;
import com.du.gsfw.model.dto.request.DemoUserLoginRequestDTO;
import com.du.gsfw.model.dto.request.DemoUserPageRequestDTO;
import com.du.gsfw.model.dto.request.DemoUserUpdateRequestDTO;
import com.du.gsfw.model.dto.response.DemoUserResponseDTO;
import com.du.gsfw.model.entity.DemoUser;

import java.util.List;

public interface DemoUserService extends IService<DemoUser> {
    DemoUser findByUserName(String userName);

    DemoUser findByEmail(String email);

    DemoUser findByMobile(String mobile);

    DemoUser findByUserNameAndPassword(String userName, String password);

    List<DemoUser> mobileLike(String mobile);

    List<DemoUser> userNameLike(String userName);

    Boolean create(DemoUserAddRequestDTO demoUserAddRequestDTO);

    void update(DemoUserUpdateRequestDTO demoUserUpdateRequestDTO) throws IncorrectParameterException;

    void delete(Long id);

    IPageModel<DemoUserResponseDTO> list(DemoUserPageRequestDTO param);

    DemoUserResponseDTO findById(Long id);

    DemoUser login(DemoUserLoginRequestDTO demoUserLoginRequestDTO);

    void loginSuccess(DemoUser demoUser);
}
