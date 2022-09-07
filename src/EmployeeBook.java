public class EmployeeBook {
    private Employee[] array;

    public EmployeeBook(Employee[] newarray) {
        this.array = newarray;
    }

    public Employee[] getArray() {
        return array;
    }

    public void setArray(Employee[] array) {
        this.array = array;
    }

    public int getAmountOfSalary(Employee[] array) {
        int amount = 0;

        for (int i = 0; i < array.length; i++) {
            amount = amount + array[i].getSalary();
        }
        return amount;
    }

    public int getAmountOfSalary(Employee[] array, int departmentForSelection) {
        int amount = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i].getDepartment() == departmentForSelection) {
                amount = amount + array[i].getSalary();
            }
        }
        return amount;
    }

    public Employee getMinSalary(Employee[] array) {
        int minimum = array[0].getSalary();
        Employee employee = array[0];

        for (int i = 1; i < array.length; i++) {
            int salary = array[i].getSalary();
            if (minimum > salary) {
                minimum = salary;
                employee = array[i];
            }
        }
        return employee;
    }

    public Employee getMinSalary(Employee[] array, int departmentForSelection) {
        int minimum = 0;
        Employee employee = array[0];

        for (int i = 0; i < array.length; i++) {
            int salary = array[i].getSalary();
            int department = array[i].getDepartment();
            if (department == departmentForSelection && (minimum == 0 || minimum > salary)) {
                minimum = salary;
                employee = array[i];
            }
        }
        return employee;
    }

    public Employee getMaxSalary(Employee[] array) {
        int maximum = array[0].getSalary();
        Employee employee = array[0];
        for (int i = 1; i < array.length; i++) {
            int salary = array[i].getSalary();
            if (maximum < salary) {
                maximum = salary;
                employee = array[i];
            }
        }
        return employee;
    }

    public Employee getMaxSalary(Employee[] array, int departmentForSelection) {
        int maximum = 0;
        Employee employee = array[0];
        for (int i = 1; i < array.length; i++) {
            int salary = array[i].getSalary();
            int department = array[i].getDepartment();
            if (department == departmentForSelection && maximum < salary) {
                maximum = salary;
                employee = array[i];
            }
        }
        return employee;
    }

    public int getAvaregeSalary(Employee[] array) {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i].getSalary();

        }
        return sum / array.length;
    }

    public int getAvaregeSalary(Employee[] array, int departmentForSelection) {
        int sum = 0;
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i].getDepartment() == departmentForSelection) {
                sum = sum + array[i].getSalary();
                count++;
            }

        }
        return sum / count;
    }

    public Employee[] indexSalary(Employee[] array, int index) {
        for (int i = 0; i < array.length; i++) {
            Employee employee = array[i];
            int oldSalary = employee.getSalary();
            double perIndex = 1.00 + (double) index / 100;
            double newSalary = (double) oldSalary * perIndex;
            employee.setSalary((int) newSalary);
        }
        return array;
    }

    public Employee[] indexSalary(Employee[] array, int index, int departmentForSelection) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].getDepartment() == departmentForSelection) {
                Employee employee = array[i];
                int oldSalary = employee.getSalary();
                double perIndex = 1.00 + (double) index / 100;
                double newSalary = (double) oldSalary * perIndex;
                employee.setSalary((int) newSalary);
            }
        }
        return array;
    }

    public Employee[] addNewWorker(Employee[] array, Employee newWorker) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = newWorker;
                break;
            }
        }

        return array;
    }

    public Employee[] deleteWorker(Employee[] array, String name, int id) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].getName() == name || array[i].getId() == id) {
                array[i] = null;
                break;
            }
        }
        return array;
    }

    public Employee[] changeWorker(Employee[] array, String name, int newDepartment, int newSalary) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].getName() == name) {
                if (newDepartment != 0) {
                    array[i].setDepartment(newDepartment);
                }
                if (newSalary != 0) {
                    array[i].setSalary(newSalary);

                }
                break;
            }
        }
        return array;
    }


}