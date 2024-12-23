package com.du.gsfw.contorller;

import com.du.gsfw.contorller.demo.BaseController;
import com.du.gsfw.model.entity.Employees;
import com.du.gsfw.service.EmployeeService;
import com.du.gsfw.utils.R;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "cmployees")
@RestController
@RequestMapping("api/cmployees")
@AllArgsConstructor
@Validated
public class EmployeeController extends BaseController {
    @Resource
    private EmployeeService employeeService;
    @Operation(summary = "add employees")
    @PostMapping
    public R add(@Validated @RequestBody Employees employees) {
        employeeService.creat(employees);
        return R.success();
    }
    @Operation(summary = "update employees")
    @PutMapping
    public R update(@Validated @RequestBody Employees employees) {
        employeeService.update(employees);
        return R.success();
    }
    @Operation(summary = "delete employees")
    @DeleteMapping
    public R del(@RequestParam("id") Long id) {
        employeeService.delete(id);
        return R.success();
    }
    @Operation(summary = "search one employees", description = "search one employees")
    @GetMapping("/detail")
    public R detail(@RequestParam("id") Long id) {
        return R.success(employeeService.findById(id));
    }

    @Operation(summary = "search all employees", description = "search all employees")
    @GetMapping("/list")
    public R list() {
        return R.success(employeeService.selectAll());
    }

    @Operation(summary = "search employees by lastName", description = "search employees by lastName")
    @GetMapping("/listByLikeLastName")
    public R listByLikeLastName(@RequestParam("lastName") String lastName) {
        return R.success(employeeService.selectByLikeLastName(lastName));
    }
    @Operation(summary = "search employees by firstName", description = "search employees by firstName")
    @GetMapping("/listByLikeFirstName")
    public R listByLikeFirstName(@RequestParam("firstName") String firstName) {
        return R.success(employeeService.selectByLikeFirstName(firstName));
    }
    @Operation(summary = "search employees by firstName", description = "search employees by firstName")
    @GetMapping("/listLikeLastNameAndFirstName")
    public R selectByLikeLastNameAndFirstName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return R.success(employeeService.selectByLikeLastNameAndFirstName(firstName, lastName));
    }

    @Operation(summary = "search employees by birthDate", description = "search employees by birthDate")
    @GetMapping("/listByLikeBirthDate")
    public R listByLikeBirthDate(@RequestParam("birthDate") String birthDate) {
        return R.success(employeeService.selectByLikeBirthDate(birthDate));
    }
}
