package com.skypro.employee.controller;

import com.skypro.employee.model.Employee;
import com.skypro.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    public final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public Collection<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @PostMapping
    public Employee addEmployee(@RequestBody EmployeeRequest employeeRequest){
        return employeeService.addEmployee(employeeRequest);
    }
@GetMapping("/salary/sum ")
    public int getSumOfSalaries(){
        return employeeService.getSumOfSalaries();
    }
    @GetMapping("/salary/min ")
    public Employee getEmployeeWithMinSalary(){
    return employeeService.getEmployeeWithMinSalary();
    }
    @GetMapping("/salary/max")
    public Employee getEmployeeWithMaxSalary(){
        return employeeService.getEmployeeWithMaxSalary();
    }
    @GetMapping("/salary-more-average ")
    public Collection<Employee> getEmployeeWithSalaryMoreAverage(){
        return employeeService.getEmployeeWithSalaryMoreAverage();
    }



}

