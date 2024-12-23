package com.du.gsfw.contorller;

import com.du.gsfw.contorller.demo.BaseController;
import com.du.gsfw.model.entity.Suppliers;
import com.du.gsfw.service.SupplierService;
import com.du.gsfw.utils.R;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "suppliers")
@RestController
@RequestMapping("api/suppliers")
@Validated
@AllArgsConstructor
public class SupplierController extends BaseController {
    @Resource
    private SupplierService supplierService;

    @PostMapping
    @Operation(summary = "add suppliers")
    public R add(@Validated @RequestBody Suppliers suppliers) {
        supplierService.create(suppliers);
        return R.success();
    }
    @PutMapping
    @Operation(summary = "update suppliers")
    public R update(@Validated @RequestBody Suppliers suppliers) {
        supplierService.update(suppliers);
        return R.success();
    }
    @Operation(summary = "delete suppliers")
    @DeleteMapping
    public R delete(@RequestParam("id") Long id) {
        supplierService.delete(id);
        return R.success();
    }
    @Operation(summary = "search one suppliers" ,description = "search one suppliers")
    @GetMapping("/detail")
    public R detail(@RequestParam("id") Long id) {
        supplierService.findById(id);
        return R.success();
    }
    @Operation(summary = "search all suppliers" , description = "search all suppliers")
    @GetMapping("/list")
    public R list() {
        return R.success(supplierService.selectAll());
    }

    @Operation(summary = "search suppliers by like name")
    @GetMapping("/name")
    public R findByLikeSupplierName(@RequestParam("name") String name) {
        return R.success(supplierService.findByLikeSupplierName(name));
    }
    @Operation(summary = "search suppliers by like address")
    @GetMapping("/address")
    public R findByLikeAddress(@RequestParam("address") String address) {
        return R.success(supplierService.findByLikeAddress(address));
    }

    @Operation(summary = "search suppliers by like contact")
    @GetMapping("/contact")
    public R findByLikeContactName(@RequestParam("contact") String contact) {
        return R.success(supplierService.findByLikeContactName(contact));
    }
    @Operation(summary = "search suppliers by like phone")
    @GetMapping("/phone")
    public R findByLikePhone(@RequestParam("phone") String phone) {
        return R.success(supplierService.findByLikePhone(phone));
    }

    @Operation(summary = "search suppliers by like city")
    @GetMapping("/city")
    public R findByLikeCity(@RequestParam("city") String city) {
        return R.success(supplierService.findByLikeCity(city));
    }
    @Operation(summary = "search suppliers by like country")
    @GetMapping("/country")
    public R findByLikeCountry(@RequestParam("country") String country) {
        return R.success(supplierService.findByLikeCountry(country));
    }
    @Operation(summary = "search suppliers by like postalCode")
    @GetMapping("/postalCode")
    public R findByLikePostalCode(@RequestParam("postalCode") String postalCode) {
        return R.success(supplierService.findByLikePostalCode(postalCode));
    }
}




















