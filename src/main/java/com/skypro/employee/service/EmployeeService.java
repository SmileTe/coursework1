package com.skypro.employee.service;

import com.skypro.employee.model.Employee;
import com.skypro.employee.model.EmployeeBook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeBook employeeBook;

    public EmployeeService(EmployeeBook employeeBook) {
        this.employeeBook = employeeBook;
    }

    public List<Employee> getEmployees() {
        return employeeBook.getArray();
    }

    public Employee addEmployee(EmployeeRequest employeeRequest) {
        final Employee newEmployee = createEmployeeFromRequest(employeeRequest, employeeBook.getLastId());
        employeeBook.addNewWorker(newEmployee);
        return newEmployee;

    }

    public int getSumOfSalaries(){
        return employeeBook.getArray().stream()
                .mapToInt(Employee::getSalary).sum();
    }

    public Employee getEmployeeWithMinSalary(){
        return employeeBook.getArray().stream()
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseGet(()->null);
    }

    public Employee getEmployeeWithMaxSalary(){
        return employeeBook.getArray().stream()
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseGet(()->null);
    }

    public List<Employee> getEmployeeWithSalaryMoreAverage(){
        int average = employeeBook.getAverageSalary();
        return employeeBook.getArray().stream()
                .filter(employee -> employee.getSalary() > average)
                .collect(Collectors.toList());
    }




}


}
//    public EmployeeService(ArrayList<Employee> array, EmployeeBook employeeBook) {
//        this.array = array;
//        this.employeeBook = employeeBook;
//    }
//
//    public void printAllEmlployee() {
//        //список всех сотрудников
//        for (int i = 0; i < this.array.size(); i++) {
//            if (this.array.get(i) != null) {
//                System.out.println(this.array.get(i).toString());
//            }
//        }
//    }
//
//    public void printAAmountOfSalary() {
//        //сумма зп
//        System.out.println(this.employeeBook.getAmountOfSalary(array));
//    }
//
//    public void getMinSalary() {
//        //мин зп
//        System.out.println(employeeBook.getMinSalary(array).toString());
//    }
//
//    public void getMaxSalary() {
//        //мах зп
//        System.out.println(employeeBook.getMaxSalary(array).toString());
//    }
//
//    public void getAverageSalary() {
//        //средн значение зп
//        System.out.println(employeeBook.getAverageSalary(array));
//    }
//
//    public void printNameAllEmployees() {
//        //фио всех сотрудников
//        for (int i = 0; i < this.array.size(); i++){
//            if (this.array.get(i) != null) {
//                System.out.println(this.array.get(i).getFirstName() + " " + this.array.get(i).getLastName());
//            }
//        }
//    }
//
//    //по департаментам
//    public void getMinSalary(ArrayList<Employee> array, int departmentForSelection) {
//        // 1. Сотрудника с минимальной зарплатой по отделу.
//        System.out.println(employeeBook.getMinSalary(array, departmentForSelection).toString());
//    }
//
//    public void getMaxSalary(ArrayList<Employee> array, int departmentForSelection) {
//        //2. Сотрудника с максимальной зарплатой.
//        System.out.println(employeeBook.getMaxSalary(array, departmentForSelection).toString());
//    }
//
//    public void getAmountOfSalary(ArrayList<Employee> array, int departmentForSelection) {
//        //3. Сумму затрат на зарплату по отделу.
//        System.out.println(employeeBook.getAmountOfSalary(array, departmentForSelection));
//    }
//
//    public void getAverageSalary(ArrayList<Employee> array, int departmentForSelection) {
//        //4. Среднюю зарплату по отделу (учесть, что количество людей в отделе отличается от employees.length).
//        System.out.println(employeeBook.getAverageSalary(array, departmentForSelection));
//    }
//
//    public void printEmployeesDepartment(ArrayList<Employee> array, int departmentForSelection) {
//        //6. Напечатать всех сотрудников отдела (все данные, кроме отдела).
//        for (int i = 0; i < array.size() - 1; i++) {
//            if (array.get(i) != null) {
//                if (array.get(i).getDepartment() == departmentForSelection) {
//                    System.out.println(array.get(i).toString());
//                }
////            }
////        }
////    }
//
//    public void deleteWorker() {
//        // Удалить сотрудника (находим сотрудника по Ф. И. О. и/или id, о
//        employeeBook.deleteWorker("Test", "Test", 2);
//    }
//
//    public void addNewWorker() {
//        //Добавить нового сотрудника в свободную ячейку
//        Employee newWorker = new Employee("Хрюша", "Михайлов", 1, 29_000);
//        int position = employeeBook.addNewWorker(newWorker);
//        System.out.println("Сотрудник добавлен в индекс" + position);
//    }
//
//    public void changeWorker() {
//    //Изменить сотрудника (получить сотрудника по Ф. И. О., изменить зп и/или отдел):
//        employeeBook.changeWorker(array, "Хрюша", "Михайлов", 2, 22_000);
//    }
//
//
//    public void printAllEmployeesWithDepartments() {
//        //Получить Ф. И. О. всех сотрудников по отделам (напечатать список отделов и их сотрудников).
//        for (int iDepartment = 1; iDepartment <= 5; iDepartment++) {
//            System.out.println("------------------------------");
//            System.out.println(iDepartment);
//            for (int i = 0; i < array.size() - 1; i++) {
//                if (array.get(i) != null) {
//                    if (array.get(i).getDepartment() == iDepartment) {
//                        System.out.println(array.get(i));
//                    }
//                }
//
//            }
//
//        }
//    }
//
//
//
//}
