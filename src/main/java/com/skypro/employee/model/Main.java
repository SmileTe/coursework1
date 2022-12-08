package com.skypro.employee.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        Employee[] array = new Employee[10];
//        array[0] = new Employee("иван", "иванов",1, 20_000);
//        array[1] = new Employee("Петр", "Петров", 2, 25_000);
//        array[2] = (new Employee("Сидор","Сидоров", 3, 30_000));
//        array[3] = (new Employee("Павел","Павлов", 4, 20_000));
//        array[4] = (new Employee("Евгений", "Евгеньевич", 5, 25_000));
//        //array[5] = null;//(new com.skypro.employee.model.Employee("Смирнов В.В", 1, 35_000));
//        array[6] = (new Employee("Василий", "Васильев", 2, 40_000));
//        array[7] = (new Employee("Сергей", "Иванов", 3, 45_000));
//        array[8] = (new Employee("Геннадий", "Крокодил", 4, 50_000));
//        array[9] = new Employee("Павел", "Соколов", 5, 55_000);
//        EmployeeBook employeeBook = new EmployeeBook(array);
//
//        task1(employeeBook);
//
//       task2(employeeBook, 2);
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите число");
//        int num = scanner.nextInt();
//        //Всех сотрудников с зарплатой меньше числа (вывести id, Ф. И. О. и зарплатой в консоль).
//        System.out.println("-----------------");
//        System.out.println("Сотрудники с зарплатой меньше числа");
//        for (int i = 0; i < array.length; i++) {
//            if(array[i] !=null ){
//                if(array[i].getSalary()<num) {
//                    System.out.printf("%1d %2s %3s %4d", array[i].getId(), array[i].getFirstName(), array[i].getLastName(), array[i].getSalary());
//                    System.out.println();
//                }
//            }
//
//        }
//        //Всех сотрудников с зарплатой меньше числа (вывести id, Ф. И. О. и зарплатой в консоль).
//        System.out.println("-----------------");
//        System.out.println("Сотрудники с зарплатой больше (или равно) числа");
//        for (int i = 0; i < array.length; i++) {
//            if(array[i] !=null ){
//                if(array[i].getSalary()>=num) {
//                    System.out.printf("%1d, %2s %3s %4d", array[i].getId(), array[i].getFirstName(), array[i].getLastName(), array[i].getSalary());
//                    System.out.println();
//                }
//            }
//        }
//
//        task3(employeeBook);
    }

    public static void task1(EmployeeBook employeeBook) {
//        Employee[] array = employeeBook.getArray();
//
//        //список всех сотрудников
//        for (int i = 0; i < array.length; i++) {
//            if(array[i] !=null ){
//                System.out.println(array[i].toString());
//            }
//
//        }
//
//        //сумма зп
//        System.out.println(employeeBook.getAmountOfSalary(array));
//
//        //мин зп
//        System.out.println(employeeBook.getMinSalary(array).toString());
//
//        //мах зп
//        System.out.println(employeeBook.getMaxSalary(array).toString());
//
//        //средн значение зп
//        System.out.println(employeeBook.getAverageSalary(array));
//
//        //фио всех сотрудников
//        for (int i = 0; i < array.length; i++) {
//            if(array[i] !=null ){
//                System.out.println(array[i].getFirstName() + " " + array[i].getLastName());
//            }
//
//        }
//
//        array = employeeBook.indexSalary(array, 6);
//
//        //список всех сотрудников
//        for (int i = 0; i < array.length; i++) {
//            if(array[i] !=null ){
//                System.out.println(array[i].toString());
//            }
//
//        }
    }

    public static void task2(EmployeeBook employeeBook, int departmentForSelection) {
//        List<Employee> array = employeeBook.getArray();
//
//        // 1. Сотрудника с минимальной зарплатой по отделу.
//        System.out.println(employeeBook.getMinSalary(array, departmentForSelection).toString());
//
//        //2. Сотрудника с максимальной зарплатой.
//        System.out.println(employeeBook.getMaxSalary(array, departmentForSelection).toString());
//
//        //3. Сумму затрат на зарплату по отделу.
//        System.out.println(employeeBook.getAmountOfSalary(array, departmentForSelection));
//
//        //4. Среднюю зарплату по отделу (учесть, что количество людей в отделе отличается от employees.length).
//        System.out.println(employeeBook.getAverageSalary(array, departmentForSelection));
//
//        //5. Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра.
//       // array = employeeBook.indexSalary(array, 6, departmentForSelection);
//
//        //6. Напечатать всех сотрудников отдела (все данные, кроме отдела).
//        for (int i = 0; i < array.size()-1; i++) {
//            if(array.get(i) !=null ){
//                if (array.get(i).getDepartment() == departmentForSelection) {
//                    System.out.println(array.get(i).toString());
//                }
//            }
//
//        }
    }

    public static void task3(EmployeeBook employeeBook) {
//        List<Employee> array = employeeBook.getArray();
//
//        // Удалить сотрудника (находим сотрудника по Ф. И. О. и/или id, о
//        employeeBook.deleteWorker("Test","Test",2);
//
//        //Добавить нового сотрудника в свободную ячейку
//        Employee newWorker = new Employee("Хрюша", "Михайлов",1, 29_000);
//        int position = employeeBook.addNewWorker(newWorker);
//        System.out.println("Сотрудник добавлен в индекс" + position);
//
//        //Изменить сотрудника (получить сотрудника по Ф. И. О., изменить зп и/или отдел):
//         employeeBook.changeWorker(array, "Хрюша","Михайлов", 2, 22_000);
//
//        //Получить Ф. И. О. всех сотрудников по отделам (напечатать список отделов и их сотрудников).
//        for (int iDepartment = 1; iDepartment <= 5; iDepartment++) {
//            System.out.println("------------------------------");
//            System.out.println(iDepartment);
//            for (int i = 0; i < array.size()-1; i++) {
//                if(array.get(i) !=null ){
//                    if (array.get(i).getDepartment() == iDepartment) {
//                        System.out.println(array.get(i));
//                    }
//                }
//
//            }
//
//        }
    }
}