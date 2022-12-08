package com.skypro.employee.controller;

import com.skypro.employee.model.Employee;
import com.skypro.employee.service.DepartmentService;
import com.skypro.employee.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.event.ListDataListener;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

  public final DepartmentService departmentService;

  public DepartmentController(DepartmentService departmentService) {
    this.departmentService = departmentService;
  }

  @GetMapping
  public String getExistingsDepartments(){
    return "Departments:"  + departmentService.getExistingsDepartments().toString();
  }

  @GetMapping("/employees")
  public Map<Integer, List<Employee>> getEmployeesByDepartment(@PathVariable("id") int departmentId){
    return departmentService.getEmployeesByDepartment(departmentId);
  }

  @GetMapping("/{id}/employees")
  public ArrayList<Employee> getEmployeesFromDepartment(@PathVariable("id") int departmentId){
//    List<Employee> filteredEmployees = employeeService.getEmployees().stream()
//            .filter(employee -> employee.getDepartment() == departmentId)
//            .collect(Collectors.toList());
//    return new ArrayList<Employee>(filteredEmployees);
//    List<Employee> employees = employeeService.getEmployees();
//    ArrayList<Employee> filteredEmployees= new ArrayList<>();
//    for (Employee employee:employees) {
//      if(employee.getDepartment() == departmentId){
//        filteredEmployees.add(employee);
//      }
//    }
//
//    return filteredEmployees;
    List<Employee> employees =   departmentService.getEmployeesFromDepartment(departmentId);
 return new ArrayList<Employee>(employees);
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
