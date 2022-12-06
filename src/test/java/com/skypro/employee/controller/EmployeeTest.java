package com.skypro.employee.controller;

import com.skypro.employee.model.Employee;
import com.skypro.employee.model.EmployeeBook;
import com.skypro.employee.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

public class EmployeeTest {
    EmployeeService employeeService;

/*
Необходимо покрыть тестами все
операции по работе с сотрудниками из EmployeeService (добавление, удаление, поиск).
 */
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
    public void getEmployees(){
        Collection<Employee> test1 = employeeService.getEmployees();
    }

    @Test
    public void addEmployee(){
        Employee newWorker = new Employee("Хрюша", "Михайлов",1, 29_000);
       employeeService.addEmployee(newWorker);
        Collection<Employee> test1 = employeeService.getEmployees();
        for (Employee employee:test1) {
            System.out.println(employee);
        }
    }

    @Test
    public void deleteWorker(){
        employeeService.deleteWorker("Павел", "Павлов" , 3);
        for (Employee employee:employeeService.getEmployees()) {
            System.out.println(employee );
        }
    }


    @Test
    public void getSumOfSalaries(){
       // сумма зп
        System.out.println(employeeService.getSumOfSalaries());
    }


    @Test
    public void getEmployeeWithMinSalary(){
        System.out.println(employeeService.getEmployeeWithMinSalary());
    }

    @Test
    public void getEmployeeWithMaxSalary(){
        System.out.println(employeeService.getEmployeeWithMaxSalary());
    }

    @Test
    public void getEmployeeWithSalaryMoreAverage(){
       Collection<Employee> test1 = employeeService.getEmployeeWithSalaryMoreAverage();
        for (Employee employee:test1) {
            System.out.println(employee );
        }
    }







}
