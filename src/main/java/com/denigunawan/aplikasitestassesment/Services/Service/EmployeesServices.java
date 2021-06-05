package com.denigunawan.aplikasitestassesment.Services.Service;


import com.denigunawan.aplikasitestassesment.Model.Dto.EmployeesDto;
import com.denigunawan.aplikasitestassesment.Model.Employees;

import java.util.List;

public interface EmployeesServices {

    List<Employees> findAllEmployees();

    Employees saveEmployees(EmployeesDto employeesDto);

    Employees findEmployeesById(Long id);

    EmployeesDto updateEmployees(EmployeesDto employeesDto);

    void deleteEmployeesById(Long id);
}
