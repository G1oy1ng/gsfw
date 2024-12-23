package com.du.gsfw.contorller;

import com.du.gsfw.contorller.demo.BaseController;
import com.du.gsfw.model.entity.Orders;
import com.du.gsfw.service.OrderService;
import com.du.gsfw.utils.R;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "orders")
@AllArgsConstructor
@RestController
@RequestMapping("api/orders")
@Validated
public class OrderController extends BaseController {
    @Resource
    private OrderService orderService;

    @Operation(summary = "add orders")
    @PostMapping
    public R add(@Validated @RequestBody Orders orders) {
        return R.success(orderService.create(orders));
    }

    @Operation(summary = "edit orders")
    @PutMapping
    public R update(@Validated @RequestBody Orders orders) {
        return R.success(orderService.update(orders));
    }

    @Operation(summary = "delete orders")
    @DeleteMapping
    public R del(@RequestParam("id") Long id) {
        orderService.delete(id);
        return R.success();
    }

    @Operation(summary = "search one orders", description = "search one orders")
    @GetMapping("/detail")
    public R detail(@RequestParam("id") Long id) {
        return R.success(orderService.findById(id));
    }

    @Operation(summary = "search all orders", description = "search all orders")
    @GetMapping("/list")
    public R list() {
        return R.success(orderService.selectAll());
    }

    @Operation(summary = "search orders by customerId", description = "search orders by customerId")
    @GetMapping("/searchCustomerId")
    public R findByCustomerId(@RequestParam("customerId") Long customerId) {
        return R.success(orderService.findByCustomerId(customerId));
    }

    @Operation(summary = "search orders by employeeId", description = "search orders by employeeId")
    @GetMapping("/searchEmployeeId")
    public R findByEmployeeId(@RequestParam("employeeId") Long employeeId) {
        return R.success(orderService.findByEmployeeId(employeeId));
    }
    @Operation(summary = "search orders by shipperId", description = "search orders by shipperId")
    @GetMapping("/searchShipperIdd")
    public R findByShipperId(@RequestParam("shipperId") Long shipperId) {
        return R.success(orderService.findByShipperId(shipperId));
    }
    @Operation(summary = "search orders by orderDate", description = "search orders by orderDate")
    @GetMapping("/searchOrderDate")
    public R findByOrderDate(@RequestParam("orderDate") String orderDate) {
        return R.success(orderService.findByOrderDate(orderDate));
    }
}
