package Week1DSA.EmployeeManagement;

import java.util.Scanner;

public class Employee {
    private int employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    // Getters and setters
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
class EmployeeManagementSystem {
    private Employee[] employees;
    private int size;
    private Scanner scanner;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        size = 0;
        scanner = new Scanner(System.in);
    }

    // Method to add an employee
    public void addEmployee() {
        if (size < employees.length) {
            System.out.print("Enter employee ID: ");
            int employeeId = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            System.out.print("Enter employee name: ");
            String name = scanner.nextLine();

            System.out.print("Enter employee position: ");
            String position = scanner.nextLine();

            System.out.print("Enter employee salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine(); // Consume newline left-over

            Employee employee = new Employee(employeeId, name, position, salary);
            employees[size] = employee;
            size++;
            System.out.println("Employee added successfully!");
        } else {
            System.out.println("Array is full. Cannot add more employees.");
        }
    }

    // Method to search for an employee by ID
    public void searchEmployee() {
        System.out.print("Enter employee ID to search: ");
        int employeeId = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                System.out.println("Employee found!");
                System.out.println("Employee ID: " + employees[i].getEmployeeId());
                System.out.println("Name: " + employees[i].getName());
                System.out.println("Position: " + employees[i].getPosition());
                System.out.println("Salary: " + employees[i].getSalary());
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    // Method to traverse the array and print employee records
    public void traverseEmployees() {
        if (size == 0) {
            System.out.println("No employees in the system!");
            return;
        }

        System.out.println("Employee Records:");
        for (int i = 0; i < size; i++) {
            System.out.println("Employee ID: " + employees[i].getEmployeeId());
            System.out.println("Name: " + employees[i].getName());
            System.out.println("Position: " + employees[i].getPosition());
            System.out.println("Salary: " + employees[i].getSalary());
            System.out.println();
        }
    }

    // Method to delete an employee by ID
    public void deleteEmployee() {
        System.out.print("Enter employee ID to delete: ");
        int employeeId = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                // Shift elements to the left
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                size--;
                System.out.println("Employee deleted successfully!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    public void run() {
        while (true) {
            System.out.println("Employee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Traverse Employees");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    searchEmployee();
                    break;
                case 3:
                    traverseEmployees();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(10);
        ems.run();
    }
}
