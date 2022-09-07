import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Employee[] array = new Employee[10];
        array[0] = new Employee("Иванов Иван Иванович", 1, 20_000);
        array[1] = new Employee("Петров Петр Петрович", 2, 25_000);
        array[2] = (new Employee("Сидоров Сидор Сидорович", 3, 30_000));
        array[3] = (new Employee("Козлов П.П", 4, 20_000));
        array[4] = (new Employee("Кузнецов Е.Е", 5, 25_000));
        array[5] = (new Employee("Смирнов В.В", 1, 35_000));
        array[6] = (new Employee("Васечкин П.П", 2, 40_000));
        array[7] = (new Employee("Рыжов Е.Е", 3, 45_000));
        array[8] = (new Employee("Васильев А.А", 4, 50_000));
        array[9] = new Employee("Соколов П.П", 5, 55_000);
        EmployeeBook employeeBook = new EmployeeBook(array);

        task1(employeeBook);
        task2(employeeBook, 2);

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

        task3(employeeBook);

    }

    public static void task1(EmployeeBook employeeBook) {
        Employee[] array = employeeBook.getArray();

        //список всех сотрудников
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].toString());
        }

        //сумма зп
        System.out.println(employeeBook.getAmountOfSalary(array));

        //мин зп
        System.out.println(employeeBook.getMinSalary(array).toString());

        //мах зп
        System.out.println(employeeBook.getMaxSalary(array).toString());

        //средн значение зп
        System.out.println(employeeBook.getAvaregeSalary(array));

        //фио всех сотрудников
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].getName());
        }

        array = employeeBook.indexSalary(array, 6);

        //список всех сотрудников
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].toString());
        }
    }

    public static void task2(EmployeeBook employeeBook, int departmentForSelection) {
        Employee[] array = employeeBook.getArray();

        // 1. Сотрудника с минимальной зарплатой по отделу.
        System.out.println(employeeBook.getMinSalary(array, departmentForSelection).toString());

        //2. Сотрудника с максимальной зарплатой.
        System.out.println(employeeBook.getMaxSalary(array, departmentForSelection).toString());

        //3. Сумму затрат на зарплату по отделу.
        System.out.println(employeeBook.getAmountOfSalary(array, departmentForSelection));

        //4. Среднюю зарплату по отделу (учесть, что количество людей в отделе отличается от employees.length).
        System.out.println(employeeBook.getAvaregeSalary(array, departmentForSelection));

        //5. Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра.
        array = employeeBook.indexSalary(array, 6, departmentForSelection);

        //6. Напечатать всех сотрудников отдела (все данные, кроме отдела).
        for (int i = 0; i < array.length; i++) {
            if (array[i].getDepartment() == departmentForSelection) {
                System.out.println(array[i].toString());
            }
        }
    }

    public static void task3(EmployeeBook employeeBook) {
        Employee[] array = employeeBook.getArray();

        // Удалить сотрудника (находим сотрудника по Ф. И. О. и/или id, о
        Employee[] newArray = employeeBook.deleteWorker(array, "Test", 2);
        employeeBook.setArray(newArray);

        //Добавить нового сотрудника в свободную ячейку
        Employee newWorker = new Employee("Хрюша М.М", 1, 29_000);
        newArray = employeeBook.addNewWorker(array, newWorker);
        employeeBook.setArray(newArray);

        //Изменить сотрудника (получить сотрудника по Ф. И. О., изменить зп и/или отдел):
        newArray = employeeBook.changeWorker(array, "Хрюша М.М", 2, 22_000);
        employeeBook.setArray(newArray);


        //Получить Ф. И. О. всех сотрудников по отделам (напечатать список отделов и их сотрудников).
        for (int iDepartment = 1; iDepartment <= 5; iDepartment++) {
            System.out.println("------------------------------");
            System.out.println(iDepartment);
            for (int i = 0; i < array.length; i++) {
                if (array[i].getDepartment() == iDepartment) {
                    System.out.println(array[i]);
                }
            }

        }
    }
}