package com.springProject.crudOperation.DAO;

import com.springProject.crudOperation.Entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        //creating a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        List<Employee> employees = theQuery.getResultList();


        return employees;
    }


    //get by ID
    @Override
    public Employee findById(int Id) {

        Employee employee = entityManager.find(Employee.class, Id);

        return employee;
    }


    // to save to DB
    @Override
    public Employee save(Employee theEmployee) {

        Employee employee = entityManager.merge(theEmployee);

        return employee;
    }


    //to delete entry in DB
    @Override
    public void deleteById(int Id) {

       Employee theEmployee = entityManager.find(Employee.class, Id);

        entityManager.remove(theEmployee);

    }
}
