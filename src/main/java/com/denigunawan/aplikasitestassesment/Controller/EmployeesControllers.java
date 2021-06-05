package com.denigunawan.aplikasitestassesment.Controller;

import com.denigunawan.aplikasitestassesment.Config.Api.ApiResponseEmployees;
import com.denigunawan.aplikasitestassesment.Model.Employees;
import com.denigunawan.aplikasitestassesment.Model.Dto.EmployeesDto;
import com.denigunawan.aplikasitestassesment.Services.Service.EmployeesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeesControllers {

    @Autowired
    private EmployeesServices employeeService;

    @PostMapping
    public ApiResponseEmployees<Employees> saveEmployees(@RequestBody EmployeesDto employeesDto){
        return new ApiResponseEmployees<>(HttpStatus.OK.value(), "Employees saved successfully.",employeeService.saveEmployees(employeesDto));
    }

    @GetMapping
    public ApiResponseEmployees<List<Employees>> listEmployees(){
        return new ApiResponseEmployees<>(HttpStatus.OK.value(), "Employees list fetched successfully.",employeeService.findAllEmployees());
    }

    @GetMapping("/{id}")
    public ApiResponseEmployees<Employees> getOne(@PathVariable Long id){
        return new ApiResponseEmployees<>(HttpStatus.OK.value(), "Employees fetched successfully.",employeeService.findEmployeesById(id));
    }

    @PutMapping("/{id}")
    public ApiResponseEmployees<EmployeesDto> update(@RequestBody EmployeesDto employeesDto) {
        return new ApiResponseEmployees<>(HttpStatus.OK.value(), "Employees updated successfully.",employeeService.updateEmployees(employeesDto));
    }

    @DeleteMapping("/{id}")
    public ApiResponseEmployees<Void> delete(@PathVariable Long id) {
        employeeService.deleteEmployeesById(id);
        return new ApiResponseEmployees<>(HttpStatus.OK.value(), "Employees deleted successfully.", null);
    }
}
