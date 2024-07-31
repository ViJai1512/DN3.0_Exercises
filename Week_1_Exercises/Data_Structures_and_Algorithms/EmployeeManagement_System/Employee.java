class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
}

public class EmployeeManagementSystem {
    private Employee[] employees;
    private int size;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public void addEmployee(Employee employee) {
        if (size < employees.length) {
            employees[size] = employee;
            size++;
        } else {
            System.out.println("Array is full");
        }
    }

    public Employee searchEmployeeById(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    public void displayEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i].employeeId + ", " + employees[i].name + ", " + employees[i].position + ", " + employees[i].salary);
        }
    }

    public void deleteEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == employeeId) {
                // Shift elements to the left
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                size--;
                System.out.println("Employee deleted");
                return;
            }
        }
        System.out.println("Employee not found");
    }

    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem(5);

        system.addEmployee(new Employee(1, "Neetu", "Manager", 90000));
        system.addEmployee(new Employee(2, "Yash", "Developer", 100000));
        system.addEmployee(new Employee(3, "Harya", "Designer", 85000));

        system.displayEmployees();

        Employee foundEmployee = system.searchEmployeeById(2);
        if (foundEmployee != null) {
            System.out.println("Found employee: " + foundEmployee.name);
        }

        system.deleteEmployee(2);
        system.displayEmployees();
    }
}