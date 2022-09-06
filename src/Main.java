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




    }

    public static  int getAmountOfSalary(Employee[]array) {
        int amount = 0;

        for (int i = 0; i < array.length; i++) {
            amount = amount + array[i].getSalary();
        }
        return amount;
    }

    public static Employee getMinSalary(Employee[]array) {
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

    public static Employee getMaxSalary(Employee[]array) {
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

    public static int getAvaregeSalary(Employee[]array) {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum =sum + array[i].getSalary();

        }
        return sum/array.length;
    }


}