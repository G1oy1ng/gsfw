package com.du.gsfw.contorller;

import com.du.gsfw.constant.enums.CodeEnum;
import com.du.gsfw.convert.DemoUserConvert;
import com.du.gsfw.model.dto.request.DemoUserLoginRequestDTO;
import com.du.gsfw.model.dto.response.DemoUserResponseDTO;
import com.du.gsfw.model.entity.DemoUser;
import com.du.gsfw.service.DemoUserService;
import com.du.gsfw.service.impl.JwtService;
import com.du.gsfw.utils.R;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Tag(name = "login")
@RestController
@RequestMapping("api/")
@AllArgsConstructor
@Validated
public class LoginController {

    @Resource
    private DemoUserService demoUserService;

    @Resource
    private JwtService jwtService;

    @Resource
    private DemoUserConvert demoUserConvert;

    @Operation(summary = "user login")
    @PostMapping(value = "/login")
    public R login(@Validated @RequestBody DemoUserLoginRequestDTO demoUserLoginRequestDTO) {

        DemoUser demoUser = demoUserService.login(demoUserLoginRequestDTO);

        if (null == demoUser || demoUser.getDeleted()) {
            return R.error(CodeEnum.IS_FAIL.getCode(), "用户名或密码错误");
        }

        // 创建token
        String token = jwtService.generateToken(demoUser);

        demoUser.setToken(token);
        demoUserService.loginSuccess(demoUser);

        Map<String, String> result = new HashMap<>();
        result.put("token", token);
        result.put("userId", String.valueOf(demoUser.getId()));

        return R.success(result);
    }

    @Operation(summary = "get demo user info by token")
    @PostMapping(value = "/getUserInfo")
    public R getUserInfo() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        DemoUserResponseDTO demoUserDTO = demoUserConvert.toDto(demoUserService.findByUserName(userDetails.getUsername()));
        if (null == demoUserDTO) {
            return R.error(CodeEnum.IS_FAIL.getCode(), "账号不存在");
        }
        Map<String, Object> result = new HashMap<>();
        result.put("user", demoUserDTO);
        return R.success(result);
    }
}
