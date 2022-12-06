package com.skypro.employee.controller;

import com.skypro.employee.model.Employee;
import com.skypro.employee.model.EmployeeBook;
import com.skypro.employee.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentControllerTest {

    @Mock
    EmployeeBook employeeBook;


    DepartmentController departmentController;


    @InjectMocks
    ArrayList<Employee> array= new ArrayList<>();

    @Mock
    EmployeeService employeeService;


    @BeforeEach
    public void setUp(){

        ArrayList<Employee> array = new ArrayList<>(5);
        array.add(new Employee("иван", "иванов",1, 20_000));
        array.add(new Employee("Петр", "Петров", 2, 25_000));
        array.add(new Employee("Сидор","Сидоров", 3, 30_000));
        array.add(new Employee("Павел","Павлов", 4, 20_000));
        array.add(new Employee("Евгений", "Евгеньевич", 5, 25_000));

        EmployeeBook employeeBook = new EmployeeBook(array);

        employeeService = new EmployeeService(employeeBook);

    }

    @Test
    public void getEmployeesFromDepartment(){

        int departmentId = 1;
       when(employeeService.getEmployeesFromDepartment(departmentId)).thenReturn(array);
        ArrayList<Employee>test1 = departmentController.getEmployeesFromDepartment(departmentId);
        for (Employee employee:test1) {
            System.out.println(employee);
        }

    }

}
