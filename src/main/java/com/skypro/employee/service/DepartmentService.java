package com.skypro.employee.service;

import com.skypro.employee.model.Employee;
import com.skypro.employee.model.EmployeeBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeeBook employeeBook;

    @Autowired
    public DepartmentService(EmployeeBook employeeBook) {
        this.employeeBook = employeeBook;
    }

    public Set<Integer> getExistingsDepartments() {
        return employeeBook.getArray().stream()
                .map(Employee::getDepartment)
                .collect(Collectors.toSet());
    }


    public Map<Integer, List<Employee>> getEmployeesByDepartment(int departmentId) {
        return getExistingsDepartments().stream()
                .collect(Collectors.toMap(dept->dept, this::getEmployeesFromDepartment));

    }
    public List<Employee> getEmployeesFromDepartment(int departmentId) {
        return employeeBook.getArray().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .collect(Collectors.toList());
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

