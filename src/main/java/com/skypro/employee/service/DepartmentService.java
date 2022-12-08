package com.skypro.employee.service;

import com.skypro.employee.model.Employee;
import com.skypro.employee.model.EmployeeBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
   // private final EmployeeBook employeeBook;
    private final EmployeeService employeeService;

//     public DepartmentService() {
//        this.employeeService = new EmployeeService();
//    }

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public Set<Integer> getExistingsDepartments() {
//        return employeeBook.getArray().stream()
//                .map(Employee::getDepartment)
//                .collect(Collectors.toSet());
        Set<Integer> employeeMap = new HashSet<>();
        return employeeMap;

    }


    public Map<Integer, List<Employee>> getEmployeesByDepartment(int departmentId) {
        return getExistingsDepartments().stream()
                .collect(Collectors.toMap(dept->dept, this::getEmployeesFromDepartment));

    }
    public List<Employee> getEmployeesFromDepartment(int departmentId) {
//        return employeeBook.getArray().stream()
//                .filter(employee -> employee.getDepartment() == departmentId)
//                .collect(Collectors.toList());
        List<Employee> employees = employeeService.getEmployees();
        ArrayList<Employee> filteredEmployees= new ArrayList<>();
    for (Employee employee:employees) {
      if(employee.getDepartment() == departmentId){
        filteredEmployees.add(employee);
      }
    }

    return filteredEmployees;
    }

    public int getSalarySumOfDepartment(int departmentId){
        return getEmployeesFromDepartment(departmentId).stream()
                .mapToInt(Employee::getSalary)
                .sum();
    }
    public int getMinSalaryOfDepartment(int departmentId){
        return getEmployeesFromDepartment(departmentId).stream()
                .mapToInt(Employee::getSalary)
                .min().getAsInt();
    }

    public int getMaxSalaryOfDepartment(int departmentId){
        return getEmployeesFromDepartment(departmentId).stream()
                .mapToInt(Employee::getSalary)
                .max().getAsInt();
    }

}

