package com.du.gsfw.contorller;

import com.du.gsfw.contorller.demo.BaseController;
import com.du.gsfw.model.entity.OrderDetails;
import com.du.gsfw.service.OrderDetailService;
import com.du.gsfw.utils.R;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "orderDetails")
@RestController
@RequestMapping("api/orderDetails")
@Validated
@AllArgsConstructor
public class OrderDetailController extends BaseController {
    @Resource
    private OrderDetailService orderDetailService;

    @Operation(summary = "add orderDetails")
    @PostMapping
    public R add(@Validated @RequestBody OrderDetails orderDetails) {
        return R.success( orderDetailService.create(orderDetails));
    }
    @Operation(summary = "update orderDetails")
    @PutMapping
    public R update(@Validated @RequestBody OrderDetails orderDetails) {
        return R.success( orderDetailService.update(orderDetails));
    }
    @Operation(summary = "delete orderDetails")
    @DeleteMapping
    public R del(@RequestParam("id") Long id) {
        orderDetailService.delete(id);
        return R.success();
    }
    @Operation(summary = "search one orderDetails", description = "search one orderDetails")
    @GetMapping("/detail")
    public R detail(@RequestParam("id") Long id) {
        return R.success( orderDetailService.findById(id));
    }
    @Operation(summary = "search all orderDetails", description = "search all orderDetails")
    @GetMapping("/list")
    public R list() {
        return R.success( orderDetailService.selectAll());
    }
    @Operation(summary = "search orderDetails by orderId", description = "search orderDetails by orderId")
    @GetMapping("/listByOrderId")
    public R listByOrderId(@RequestParam("orderId") Long orderId) {
        return R.success( orderDetailService.findByOrderId(orderId));
    }
    @Operation(summary = "search orderDetails by productId", description = "search orderDetails by productId")
    @GetMapping("/listByProductId")
    public R listByProductId(@RequestParam("productId") Long productId) {
        return R.success( orderDetailService.findByProductId(productId));
    }
}
