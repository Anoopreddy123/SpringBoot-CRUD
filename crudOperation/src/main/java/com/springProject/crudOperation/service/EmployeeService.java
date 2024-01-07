package com.springProject.crudOperation.service;

import com.springProject.crudOperation.Entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findById(int Id);
    Employee save(Employee theEmployee);
    void deleteById(int Id);
}
