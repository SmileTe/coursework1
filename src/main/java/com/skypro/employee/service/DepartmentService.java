package com.skypro.employee.service;

import com.skypro.employee.model.Employee;
import com.skypro.employee.model.EmployeeBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public Set<Integer> getExistingsDepartments() {
        return employeeService.getEmployees().stream()
                .map(Employee::getDepartment)
                .collect(Collectors.toSet());
    }

    public Map<Integer, List<Employee>> getEmployeesByDepartment(int departmentId) {
        return getExistingsDepartments().stream()
                .collect(Collectors.toMap(dept->dept, this::getEmployeesFromDepartment));

    }

    public List<Employee> getEmployeesFromDepartment(int departmentId) {
        List<Employee> employees = employeeService.getEmployees();
        ArrayList<Employee> filteredEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getDepartment() == departmentId) {
                filteredEmployees.add(employee);
            }
        }
        return filteredEmployees;
    }

    public int getSalarySumOfDepartment(int departmentId) {
        List<Employee> employees = employeeService.getEmployees();
        ArrayList<Employee> filteredEmployees = new ArrayList<>();
        int sum = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == departmentId) {
                sum = sum + employee.getSalary();
            }
        }
        return sum;
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

