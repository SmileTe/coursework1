import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Employee[] array = new Employee[10];
        array[0] = new Employee("Иванов Иван Иванович",1, 20_000);
        array[1] = new Employee("Петров Петр Петрович",2, 25_000);
        array[2] = (new Employee("Сидоров Сидор Сидорович",3, 30_000));
        array[3] = (new Employee("Козлов П.П",4, 20_000));
        array[4] = (new Employee("Кузнецов Е.Е",5, 25_000));
        array[5] = (new Employee("Смирнов В.В",1, 35_000));
        array[6] = (new Employee("Васечкин П.П",2, 40_000));
        array[7] = (new Employee("Рыжов Е.Е",3, 45_000));
        array[8] = (new Employee("Васильев А.А",4, 50_000));
        array[9] = new Employee("Соколов П.П",5, 55_000);

        task1(array);
        task2(array, 2);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        int num = scanner.nextInt();
        //Всех сотрудников с зарплатой меньше числа (вывести id, Ф. И. О. и зарплатой в консоль).
        System.out.println("-----------------");
        System.out.println("Сотрудники с зарплатой меньше числа");
        for (int i = 0; i < array.length; i++) {
            if(array[i].getSalary()<num) {
                System.out.printf("%1d, %2s %3d", array[i].getId(), array[i].getName(), array[i].getSalary());
                System.out.println();
            }
        }
        //Всех сотрудников с зарплатой меньше числа (вывести id, Ф. И. О. и зарплатой в консоль).
        System.out.println("-----------------");
        System.out.println("Сотрудники с зарплатой больше (или равно) числа");
        for (int i = 0; i < array.length; i++) {
            if(array[i].getSalary()>=num) {
                System.out.printf("%1d, %2s %3d", array[i].getId(), array[i].getName(), array[i].getSalary());
                System.out.println();
            }
        }

    }

    public static void task1(Employee[] array) {

        //список всех сотрудников
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].toString());
        }

        //сумма зп
        System.out.println(getAmountOfSalary(array));

        //мин зп
        System.out.println(getMinSalary(array).toString());

        //мах зп
        System.out.println(getMaxSalary(array).toString());

        //средн значение зп
        System.out.println(getAvaregeSalary(array));

        //фио всех сотрудников
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].getName());
        }

        array = indexSalary(array, 6);

        //список всех сотрудников
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].toString());
        }
    }

    public static void task2(Employee[] array, int departmentForSelection) {

        // 1. Сотрудника с минимальной зарплатой по отделу.
        System.out.println(getMinSalary(array,departmentForSelection).toString());

        //2. Сотрудника с максимальной зарплатой.
        System.out.println(getMaxSalary(array,departmentForSelection).toString());

        //3. Сумму затрат на зарплату по отделу.
        System.out.println(getAmountOfSalary(array,departmentForSelection));

        //4. Среднюю зарплату по отделу (учесть, что количество людей в отделе отличается от employees.length).
        System.out.println(getAvaregeSalary(array,departmentForSelection));

        //5. Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра.
        array = indexSalary(array, 6,departmentForSelection);

        //6. Напечатать всех сотрудников отдела (все данные, кроме отдела).
        for (int i = 0; i < array.length; i++) {
            if(array[i].getDepartment()==departmentForSelection) {
                System.out.println(array[i].toString());
            }
        }
    }

    public static  int getAmountOfSalary(Employee[] array) {
        int amount = 0;

        for (int i = 0; i < array.length; i++) {
            amount = amount + array[i].getSalary();
        }
        return amount;
    }

    public static  int getAmountOfSalary(Employee[] array, int departmentForSelection) {
        int amount = 0;

        for (int i = 0; i < array.length; i++) {
            if(array[i].getDepartment()==departmentForSelection) {
                amount = amount + array[i].getSalary();
            }
        }
        return amount;
    }

    public static Employee getMinSalary(Employee[] array) {
        int minimum = array[0].getSalary();
        Employee employee = array[0];

        for (int i = 1; i < array.length; i++) {
            int salary = array[i].getSalary();
            if (minimum > salary){
                minimum = salary;
                employee = array[i];
            }
        }
        return employee;
    }

    public static Employee getMinSalary(Employee[] array, int departmentForSelection) {
        int minimum = 0;
        Employee employee = array[0];

        for (int i = 0; i < array.length; i++) {
            int salary = array[i].getSalary();
            int department = array[i].getDepartment();
            if (department == departmentForSelection && ( minimum == 0||minimum >salary)){
                minimum = salary;
                employee = array[i];
            }
        }
        return employee;
    }

    public static Employee getMaxSalary(Employee[] array) {
        int maximum = array[0].getSalary();
        Employee employee = array[0];
        for (int i = 1; i < array.length; i++) {
            int salary = array[i].getSalary();
            if (maximum < salary){
                maximum = salary;
                employee = array[i];
            }
        }
        return employee;
    }

    public static Employee getMaxSalary(Employee[] array, int departmentForSelection) {
        int maximum = 0;
        Employee employee = array[0];
        for (int i = 1; i < array.length; i++) {
            int salary = array[i].getSalary();
            int department = array[i].getDepartment();
            if (department == departmentForSelection && maximum < salary){
                maximum = salary;
                employee = array[i];
            }
        }
        return employee;
    }

    public static int getAvaregeSalary(Employee[] array) {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum =sum + array[i].getSalary();

        }
        return sum/array.length;
    }

    public static int getAvaregeSalary(Employee[] array, int departmentForSelection) {
        int sum = 0;
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if(array[i].getDepartment()==departmentForSelection) {
                sum = sum + array[i].getSalary();
                count++;
            }

        }
        return sum/count;
    }

    public static Employee[] indexSalary(Employee[] array, int index) {
        for (int i = 0; i < array.length; i++) {
       Employee employee  = array[i];
       int oldSalary = employee.getSalary() ;
       double perIndex = 1.00 + (double)index/100 ;
       double newSalary = (double) oldSalary * perIndex;
        employee.setSalary((int)newSalary);
    }
        return array;
}

    public static Employee[] indexSalary(Employee[] array, int index, int departmentForSelection) {
        for (int i = 0; i < array.length; i++) {
            if(array[i].getDepartment()==departmentForSelection) {
                Employee employee = array[i];
                int oldSalary = employee.getSalary();
                double perIndex = 1.00 + (double) index / 100;
                double newSalary = (double) oldSalary * perIndex;
                employee.setSalary((int) newSalary);
            }
        }
        return array;
    }

}