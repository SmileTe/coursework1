package com.skypro.employee.controller;

import com.skypro.employee.model.Employee;
import com.skypro.employee.model.EmployeeBook;
import com.skypro.employee.service.DepartmentService;
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
import java.util.Map;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentControllerTest {

    private DepartmentController departmentController;
    private DepartmentService departmentService;
    @InjectMocks
    private ArrayList<Employee> array= new ArrayList<>();
     @Mock
     private EmployeeService employeeService;
    @Mock
    private EmployeeBook employeeBook;
    @BeforeEach
    public void setUp(){

       // ArrayList<Employee> array = new ArrayList<>(5);
        array.add(new Employee("иван", "иванов",1, 20_000));
        array.add(new Employee("Петр", "Петров", 1, 25_000));
        array.add(new Employee("Сидор","Сидоров", 3, 30_000));
        array.add(new Employee("Павел","Павлов", 4, 20_000));
        array.add(new Employee("Евгений", "Евгеньевич", 5, 25_000));

        departmentService = new DepartmentService(employeeService);
        departmentController = new DepartmentController(departmentService);
    }

    @Test
    public void getEmployeesFromDepartment(){

        int departmentId = 1;
       when(employeeService.getEmployees()).thenReturn(array);
        ArrayList<Employee>test1 = departmentController.getEmployeesFromDepartment(departmentId);
        for (Employee employee:test1) {
            System.out.println(employee);
        }
    }

    //возвращает сумму зарплат по департаменту.
    @Test
    public void getSalarySumOfDepartment(){
        int departmentId = 1;
        when(employeeService.getEmployees()).thenReturn(array);
        int amount = departmentService.getSalarySumOfDepartment(departmentId);
        System.out.println("amount = " + amount);
    }

    //возвращает максимальную зарплату по департаменту.
    @Test
    public void getMaxSalaryOfDepartment(){
        int departmentId = 1;
        when(employeeService.getEmployees()).thenReturn(array);
        int max = departmentService.getMaxSalaryOfDepartment(departmentId);
        System.out.println("max = " + max);
    }
    //возвращает минимальную зарплату по департаменту. 
    @Test
    public void getMinSalaryOfDepartment(){
        int departmentId = 1;
        when(employeeService.getEmployees()).thenReturn(array);
        int min = departmentService.getMinSalaryOfDepartment(departmentId);
        System.out.println("min = " + min);
    }

    //возвращает сотрудников сгруппированых по отделам в виде 
    // Map<Integer,List<Employees>> где ключ - это номер отдела, а значение - список сотрудников данного отдела. 
    @Test
    public void getEmployeesByDepartment() {
        int departmentId = 1;
        when(employeeService.getEmployees()).thenReturn(array);
        Map<Integer, List<Employee>> employees = departmentService.getEmployeesByDepartment(departmentId);
        for (Map.Entry<Integer, List<Employee>> elem : employees.entrySet()) {
            System.out.println("номер отдела = " + elem.getKey());
            List<Employee> employeeList = elem.getValue();
            for (Employee employee :
                    employeeList) {
                System.out.println("employee = " + employee);
            }
            ;
            System.out.println("------------------");
        }
    }
}
