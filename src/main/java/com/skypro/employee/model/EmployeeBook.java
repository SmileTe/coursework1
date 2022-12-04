package com.skypro.employee.model;

import java.util.ArrayList;
import java.util.List;

public class EmployeeBook {
    private List<Employee> array;
    private static int lastId;

    public EmployeeBook(ArrayList<Employee> newArray) {
        this.array = newArray;
    }

    public List<Employee> getArray() {
        return array;
    }

    public void setArray(ArrayList<Employee> array) {
        this.array = array;
    }

    public int getAmountOfSalary(ArrayList<Employee> array) {
        int amount = 0;

        for (int i = 0; i < array.size()-1; i++) {
            if(this.array.get(i) !=null ){
                amount = amount + this.array.get(i).getSalary();
            }
        }
        return amount;
    }

    public int getAmountOfSalary(ArrayList<Employee> array, int departmentForSelection) {
        int amount = 0;

        for (int i = 0; i < this.array.size()-1; i++) {
            if (this.array.get(i) != null) {
                if (this.array.get(i).getDepartment() == departmentForSelection) {
                    amount = amount + this.array.get(i).getSalary();
                }
            }
        }
        return amount;
    }

    public Employee getMinSalary(ArrayList<Employee> array) {
        int minimum = array.get(0).getSalary();
        Employee employee = array.get(0);

        for (int i = 1; i < array.size()-1; i++) {
            if(array.get(i) !=null ){
                int salary = array.get(i).getSalary();
                if (minimum > salary) {
                    minimum = salary;
                    employee = array.get(i);
                }
            }
        }
        return employee;
    }

    public Employee getMinSalary(ArrayList<Employee> array, int departmentForSelection) {
        int minimum = 0;
        Employee employee = array.get(0);

        for (int i = 0; i < array.size()-1; i++) {
            if(array.get(i) !=null ){
                int salary = array.get(i).getSalary();
                int department = array.get(i).getDepartment();
                if (department == departmentForSelection && (minimum == 0 || minimum > salary)) {
                    minimum = salary;
                    employee = array.get(i);
                }
            }
        }
        return employee;
    }

    public Employee getMaxSalary(ArrayList<Employee> array) {
        int maximum = array.get(0).getSalary();
        Employee employee = array.get(0);
        for (int i = 1; i < array.size()-1; i++) {
            if(array.get(i) !=null ){
                int salary = array.get(i).getSalary();
                if (maximum < salary) {
                    maximum = salary;
                    employee = array.get(i);
                }
            }
        }
        return employee;
    }

    public Employee getMaxSalary(ArrayList<Employee> array, int departmentForSelection) {
        int maximum = 0;
        Employee employee = array.get(0);
        for (int i = 1; i < array.size()-1; i++) {
            if(array.get(i) !=null ){
                int salary = array.get(i).getSalary();
                int department = array.get(i).getDepartment();
                if (department == departmentForSelection && maximum < salary) {
                    maximum = salary;
                    employee = array.get(i);
                }
            }
        }
        return employee;
    }

    public int getAverageSalary(ArrayList<Employee> array) {
        int sum = 0;

        for (int i = 0; i < array.size()-1; i++) {
            if(array.get(i) !=null ){
                sum = sum + array.get(i).getSalary();
            }
        }
        return sum / array.size()-1;
    }

    public int getAverageSalary(ArrayList<Employee> array, int departmentForSelection) {
        int sum = 0;
        int count = 0;

        for (int i = 0; i < array.size()-1; i++) {
            if(array.get(i) !=null ){
                if (array.get(i).getDepartment() == departmentForSelection) {
                    sum = sum + array.get(i).getSalary();
                    count++;
                }
            }
        }
        return sum / count;
    }

    public ArrayList<Employee> indexSalary(ArrayList<Employee> array, int index) {
        for (int i = 0; i < array.size()-1; i++) {
            if(array.get(i) !=null ){
                Employee employee = array.get(i);
                int oldSalary = employee.getSalary();
                double perIndex = 1.00 + (double) index / 100;
                double newSalary = (double) oldSalary * perIndex;
                employee.setSalary((int) newSalary);
            }
        }
        return array;
    }

    public ArrayList<Employee> indexSalary(ArrayList<Employee> array, int index, int departmentForSelection) {
        for (int i = 0; i < array.size()-1; i++) {
            if(array.get(i) !=null ){
                if (array.get(i).getDepartment() == departmentForSelection) {
                    Employee employee = array.get(i);
                    int oldSalary = employee.getSalary();
                    double perIndex = 1.00 + (double) index / 100;
                    double newSalary = (double) oldSalary * perIndex;
                    employee.setSalary((int) newSalary);
                }
            }
        }
        return array;
    }

    public void addNewWorker( Employee newWorker) {
//        int position = 0;
//            for (int i = 0; i < array.size()-1; i++) {
//                if (array.get(i) == null) {
//                    array.set(i, newWorker);
//                    position = i;
//                    break;
//                }
//
//            }
//            return position;
        array.add(newWorker);
        lastId++;
        }


    public void  deleteWorker( String firstName, String lastName, int id) {
        for (int i = 0; i < array.size()-1; i++) {
            if(array.get(i) !=null ){
                if (array.get(i).getFirstName() == firstName || array.get(i).getLastName() == lastName || array.get(i).getId() == id) {
                    array.set(i, null);
                    break;
                }
            }

        }

    }

    public ArrayList<Employee> changeWorker(ArrayList<Employee> array, String firstName, String lastName, int newDepartment, int newSalary) {
        for (int i = 0; i < array.size()-1; i++) {
            if(array.get(i) !=null ){
                if (array.get(i).getFirstName() == firstName ||array.get(i).getLastName() == lastName) {
                    if (newDepartment != 0) {
                        array.get(i).setDepartment(newDepartment);
                    }
                    if (newSalary != 0) {
                        array.get(i).setSalary(newSalary);

                    }
                    break;
                }
            }

        }
        return array;
    }

    public static int getLastId() {
        return lastId;
    }
}