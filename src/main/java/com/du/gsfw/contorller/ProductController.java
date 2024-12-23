package com.du.gsfw.contorller;

import com.du.gsfw.contorller.demo.BaseController;
import com.du.gsfw.model.entity.Products;
import com.du.gsfw.service.ProductService;
import com.du.gsfw.utils.R;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Tag(name = "products")
@Validated
@RestController
@RequestMapping("api/products")
public class ProductController extends BaseController {
    @Resource
    private ProductService productService;

    @Operation(summary = "add product")
    @PostMapping
    public R add(@Validated @RequestBody Products products){
        return R.success(productService.create(products));
    }
    @Operation(summary = "update product")
    @PutMapping
    public R update(@Validated @RequestBody Products products){
        return R.success(productService.update(products));
    }
    @Operation(summary = "delete product")
    @DeleteMapping("/{id}")
    public R delete(@PathVariable Long id){
        productService.delete(id);
        return R.success();
    }
    @Operation(summary = "search one orders", description = "search one orders")
    @GetMapping("/detail")
    public R findById(@PathVariable Long id){
        return R.success(productService.findById(id));
    }
    @Operation(summary = "search all orders", description = "search all orders")
    @GetMapping("/list")
    public R list(){
        return R.success(productService.selectAll());
    }
    @Operation(summary = "search product by categoryId", description = "search product by categoryId")
    @GetMapping("/listByCategoryId")
    public R listByCategoryId(@RequestParam("categoryId") Long categoryId){
        return R.success(productService.findByCategoryId(categoryId));
    }
    @Operation(summary = "search product by supplierId", description = "search product by supplierId")
    @GetMapping("/listBySupplierId")
    public R listBySupplierId(@RequestParam("supplierId") Long supplierId){
        return R.success(productService.findBysSupplierId(supplierId));
    }
}
