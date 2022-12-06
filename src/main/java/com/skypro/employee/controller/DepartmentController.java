package com.skypro.employee.controller;

import com.skypro.employee.model.Employee;
import com.skypro.employee.service.DepartmentService;
import com.skypro.employee.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

  public final EmployeeService employeeService;

  public DepartmentController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping
  public String getExistingsDepartments(){
    return "Departments:"  + employeeService.getExistingsDepartments().toString();
  }

  @GetMapping("/employees")
  public Map<Integer, List<Employee>> getEmployeesByDepartment(@PathVariable("id") int departmentId){
    return employeeService.getEmployeesByDepartment(departmentId);
  }

  @GetMapping("/{id}/employees")
  public ArrayList<Employee> getEmployeesFromDepartment(@PathVariable("id") int departmentId){
    return employeeService.getEmployeesFromDepartment(departmentId);
  }

  @GetMapping("/{id}/salary/sum")
  public int getSalarySumOfDepartment(@PathVariable("id") int departmentId){
    return employeeService.getSalarySumOfDepartment(departmentId);
  }

  @GetMapping("/{id}/salary/min")
  public int getMinSalaryOfDepartment(@PathVariable("id") int departmentId){
    return employeeService.getMinSalaryOfDepartment(departmentId);
  }

  @GetMapping("/{id}/salary/max")
  public int getMaxSalaryOfDepartment(@PathVariable("id") int departmentId){
    return employeeService.getMaxSalaryOfDepartment(departmentId);
  }





}
