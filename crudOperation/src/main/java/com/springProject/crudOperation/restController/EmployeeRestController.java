package com.springProject.crudOperation.restController;

import com.springProject.crudOperation.Entity.Employee;
import com.springProject.crudOperation.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

   private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/employee")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employee/{Id}")
    public Employee findById(@PathVariable int Id){
        return employeeService.findById(Id);
    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee theEmployee){

        theEmployee.setId(0);
        Employee dbEmoployee = employeeService.save(theEmployee);

        return dbEmoployee;
    }

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
      return  employeeService.save(theEmployee);
    }


    @DeleteMapping("/employee/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        Employee employee = employeeService.findById(employeeId);

        employeeService.deleteById(employeeId);

        return "Deleted from the DB";
    }


}
