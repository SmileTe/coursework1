package com.skypro.employee.controller;

import com.skypro.employee.model.Employee;
import com.skypro.employee.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

  public final DepartmentService departmentService;

  @Autowired
  public DepartermentController(DepartmentService departmentService) {
    this.departmentService = departmentService;
  }

  @GetMapping
  public String getExistingsDepartments(){
    return "Departments:"  + departmentService.getExistingsDepartments().toString();
  }

  @GetMapping("/employees")
  public Map<Integer, List<Employee>> getEmployeesByDepartment(){
    return departmentService.getEmployeesByDepartment();
  }

  @GetMapping("/{id}/employees")
  public Collection<Employee> getEmployeesFromDepartment(@PathVariable("id") int departmentId){
    return departmentService.getEmployeesFromDepartment(departmentId);
  }

  @GetMapping("/{id}/salary/sum")
  public int getSalarySumOfDepartment(@PathVariable("id") int departmentId){
    return departmentService.getSalarySumOfDepartment(departmentId);
  }

  @GetMapping("/{id}/salary/min")
  public int getMinSalaryOfDepartment(@PathVariable("id") int departmentId){
    return departmentService.getMinSalaryOfDepartment(departmentId);
  }

  @GetMapping("/{id}/salary/max")
  public int getMaxSalaryOfDepartment(@PathVariable("id") int departmentId){
    return departmentService.getMaxSalaryOfDepartment(departmentId);
  }





}
