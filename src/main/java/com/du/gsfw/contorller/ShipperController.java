package com.du.gsfw.contorller;

import com.du.gsfw.contorller.demo.BaseController;
import com.du.gsfw.model.entity.Shippers;
import com.du.gsfw.service.ShipperService;
import com.du.gsfw.utils.R;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "shippers")
@RestController
@RequestMapping("api/shippers")
@Validated
@AllArgsConstructor
public class ShipperController extends BaseController {
    @Resource
    private ShipperService shipperService;

    @Operation(summary = "add shippers")
    @PostMapping
    public R add(@Validated @RequestBody Shippers shippers) {
        shipperService.creat(shippers);
        return R.success();
    }
    @Operation(summary = "edit shippers")
    @PutMapping
    public R update(@Validated @RequestBody Shippers shippers) {
        shipperService.update(shippers);
        return R.success();
    }
    @Operation(summary = "delete shippers")
    @DeleteMapping
    public R del(@RequestParam("id") Long id) {
        shipperService.delete(id);
        return R.success();
    }
    @Operation(summary = "search one shippers", description = "search one shippers")
    @GetMapping("/detail")
    public R detail(@RequestParam("id") Long id) {
        return R.success(shipperService.findById(id));
    }

    @Operation(summary = "search all shippers", description = "search all shippers")
    @GetMapping("/list")
    public R list() {
        return R.success(shipperService.selectAll());
    }

    @Operation(summary = "search shippers by shipperName", description = "search shippers by shipperName")
    @GetMapping("/likeName")
    public R listByLikeShipperName(@RequestParam("shipperName") String shipperName) {
        return R.success(shipperService.selectByShipperNameLike(shipperName));
    }

    @Operation(summary = "search shippers by phone", description = "search shippers by phone")
    @GetMapping("/likePhone")
    public R listByLikePhone(@RequestParam("phone") String phone) {
        return R.success(shipperService.selectByShipperPhoneLike(phone));
    }
}
