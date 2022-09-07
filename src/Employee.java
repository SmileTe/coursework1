
public class Employee {
   private String name;
   private int department;
   private int salary;
   private int id;
   private static int count;

    @Override
    public String toString() {
        return
                "ФИО='" + name + '\'' +
                ", отдел=" + department +
                ", зарплата=" + salary;
    }


    public Employee(String name, int department, int salary)
    {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.id = count;
        count++;
    }

    public String getName() {
        return name;
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
