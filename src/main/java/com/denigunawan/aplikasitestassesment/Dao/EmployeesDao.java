package com.denigunawan.aplikasitestassesment.Dao;

import com.denigunawan.aplikasitestassesment.Model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesDao extends JpaRepository<Employees, Long> {
}
