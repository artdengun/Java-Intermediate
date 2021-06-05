package com.denigunawan.aplikasitestassesment.Services.Impl;

import com.denigunawan.aplikasitestassesment.Model.Dto.EmployeesDto;
import com.denigunawan.aplikasitestassesment.Model.Employees;
import com.denigunawan.aplikasitestassesment.Dao.EmployeesDao;
import com.denigunawan.aplikasitestassesment.Services.Service.EmployeesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeesServicesImpl  implements EmployeesServices {

    @Autowired
    EmployeesDao employeesDao;

    @Override
    public List<Employees> findAllEmployees() {
        List<Employees> employeesList = new ArrayList<>();
        employeesDao.findAll().iterator().forEachRemaining(employeesList::add);
        return employeesList;
    }

    @Override
    public Employees saveEmployees(EmployeesDto employeesDto) {
        Employees newEmployees = new Employees();
        newEmployees.setEmployeeID(employeesDto.getEmployeeID());
        newEmployees.setFirstName(employeesDto.getFirstName());
        newEmployees.setLastName(employeesDto.getLastName());
        newEmployees.setTitle(employeesDto.getTitle());
        newEmployees.setWorkPhone(employeesDto.getWorkPhone());
        return  employeesDao.save(newEmployees);
    }

    @Override
    public Employees findEmployeesById(Long id) {
        Optional<Employees> findEmployeesById = employeesDao.findById(id);
        return findEmployeesById.isPresent() ? findEmployeesById.get() : null;
    }

    @Override
    public EmployeesDto updateEmployees(EmployeesDto employeesDto) {
        Employees employees = findEmployeesById(employeesDto.getEmployeeID());
        if(employees!= null){
            employeesDao.save(employees);
        }
        return employeesDto;
    }

    @Override
    public void deleteEmployeesById(Long id) {
        employeesDao.deleteById(id);
    }
}
