package com.springProject.crudOperation.DAO;

import com.springProject.crudOperation.Entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int Id);

    Employee save(Employee theEmployee);

    void deleteById(int Id);



}
