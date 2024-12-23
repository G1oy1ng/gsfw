package com.du.gsfw.contorller;

import com.du.gsfw.contorller.demo.BaseController;
import com.du.gsfw.model.entity.Categories;
import com.du.gsfw.service.CategoriesService;
import com.du.gsfw.utils.R;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "categories")
@RestController
@RequestMapping("api/categories")
@AllArgsConstructor
@Validated
public class CategoriesController extends BaseController {
    @Resource
    private CategoriesService categoriesService;
    @Operation(summary = "add categories")
    @PostMapping
    public R add(@Validated @RequestBody Categories categories) {
        return R.success(categoriesService.create(categories));
    }

    @Operation(summary = "edit categories")
    @PutMapping
    public R update(@Validated @RequestBody Categories categories){
        return R.success(categoriesService.update(categories));
    }

    @Operation(summary = "delete categories")
    @DeleteMapping
    public R del(@RequestParam("id") Long id) {
        categoriesService.delete(id);
        return R.success();
    }

    @Operation(summary = "search one categories", description = "search one categories")
    @GetMapping("/detail")
    public R detail(@RequestParam("id") Long id) {
        return R.success(categoriesService.findById(id));
    }

    @Operation(summary = "search all categories", description = "search all categories")
    @GetMapping("/list")
    public R list() {
        return R.success(categoriesService.selectAll());
    }

    @Operation(summary = "search categories by name", description = "search categories by name")
    @GetMapping("/search")
    public R search(@RequestParam("name") String name) {
        return R.success(categoriesService.findByLikeName(name));
    }
}
