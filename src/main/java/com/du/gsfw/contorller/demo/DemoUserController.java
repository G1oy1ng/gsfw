package com.du.gsfw.contorller.demo;

import com.du.gsfw.exception.IncorrectParameterException;
import com.du.gsfw.model.dto.request.DemoUserAddRequestDTO;
import com.du.gsfw.model.dto.request.DemoUserPageRequestDTO;
import com.du.gsfw.model.dto.request.DemoUserUpdateRequestDTO;
import com.du.gsfw.model.dto.response.DemoUserResponseDTO;
import com.du.gsfw.service.DemoUserService;
import com.du.gsfw.utils.R;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "demoUser")
@RestController
@RequestMapping("api/demouser")
@AllArgsConstructor
@Validated
public class DemoUserController extends BaseController{
    @Resource
    private DemoUserService demoUserService;

    @Operation(summary = "add demo user")
    @PostMapping
    public R add(@Validated @RequestBody DemoUserAddRequestDTO demoUserAddRequestDTO) {
        demoUserService.create(demoUserAddRequestDTO);
        return R.success();
    }

    @Operation(summary = "edit demo user")
    @PutMapping
    public R update(@Validated @RequestBody DemoUserUpdateRequestDTO demoUserUpdateRequestDTO) throws IncorrectParameterException {
        demoUserService.update(demoUserUpdateRequestDTO);
        return R.success();
    }

    @Operation(summary = "delete demo user")
    @DeleteMapping
    public R del(@RequestParam("id") Long id) {
        demoUserService.delete(id);
        return R.success();
    }

    @Operation(summary = "search demo user", description = "search demo user")
    @GetMapping("/detail")
    public R<DemoUserResponseDTO> detail(@RequestParam("id") Long id) {
        return R.success(demoUserService.findById(id));
    }

    @Operation(summary = "paging query demo user")
    @GetMapping
    public R list(DemoUserPageRequestDTO params) {
        return R.success(demoUserService.list(params));
    }
}
