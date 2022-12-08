package com.skypro.employee.model;

import org.apache.commons.lang3.StringUtils;

public class Employee {
   private String firstName;
   private String lastName;
   private int department;
   private int salary;
   private int id;
   private static int count;

    @Override
    public String toString() {
        return
                "Имя='" + firstName + '\'' +
                "Фамилия='" + lastName + '\'' +
                ", отдел=" + department +
                ", зарплата=" + salary;
    }


    public Employee(String firstName,String lastName, int department, int salary)
    {
        if(StringUtils.isAlpha(firstName)==false){

            throw new IllegalArgumentException("400 Bad Request");

        }
       else if(StringUtils.isAlpha(lastName)==false){

            throw new IllegalArgumentException("400 Bad Request");

        }
        else {
            this.firstName = StringUtils.capitalize(firstName);
            this.lastName = StringUtils.capitalize(lastName);
            this.department = department;
            this.salary = salary;
            this.id = count;
            count++;
        }
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }



}
