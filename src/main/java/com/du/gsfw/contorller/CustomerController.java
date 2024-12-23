package com.du.gsfw.contorller;

import com.du.gsfw.contorller.demo.BaseController;
import com.du.gsfw.model.entity.Customers;
import com.du.gsfw.service.CustomerService;
import com.du.gsfw.utils.R;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "customers")
@RestController
@RequestMapping("api/customers")
@AllArgsConstructor
@Validated
public class CustomerController extends BaseController {
    @Resource
    private CustomerService customerService;
    @Operation(summary = "add customers")
    @PostMapping
    public R add(@Validated @RequestBody Customers customers) {
        customerService.create(customers);
        return R.success();
    }

    @Operation(summary = "edit customers")
    @PutMapping
    public R update(@Validated @RequestBody Customers customers){
        customerService.update(customers);
        return R.success();
    }

    @Operation(summary = "delete customers")
    @DeleteMapping
    public R del(@RequestParam("id") Long id) {
        customerService.delete(id);
        return R.success();
    }

    @Operation(summary = "search one customers", description = "search one customers")
    @GetMapping("/detail")
    public R detail(@RequestParam("id") Long id) {
        return R.success(customerService.findById(id));
    }

    @Operation(summary = "search all customers", description = "search all customers")
    @GetMapping("/list")
    public R list() {
        return R.success(customerService.selectAll());
    }

    @Operation(summary = "search customers by customerName", description = "search customers by customerName")
    @GetMapping("/likeName")
    public R listByLikeCustomerName(@RequestParam("customerName") String customerName) {
        return R.success(customerService.findByLikeCustomerName(customerName));
    }
}
