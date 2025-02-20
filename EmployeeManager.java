import java.util.*;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class EmployeeManager {

    static ArrayList<Employee> employees = new ArrayList<>();

    public static void addEmployee(int id, String name, double salary) {
        Employee employee = new Employee(id, name, salary);
        employees.add(employee);
    }

    public static void updateEmployee(int id, String name, double salary) {
        for (Employee employee : employees) {
            if (employee.id == id) {
                employee.name = name;
                employee.salary = salary;
                System.out.println("Employee updated: " + employee);
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    public static void removeEmployee(int id) {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.id == id) {
                iterator.remove();
                System.out.println("Employee removed: " + employee);
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    public static void searchEmployee(int id) {
        for (Employee employee : employees) {
            if (employee.id == id) {
                System.out.println("Employee found: " + employee);
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    public static void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees available.");
        } else {
            System.out.println("Employee List:");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Display All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();
                    addEmployee(id, name, salary);
                    break;

                case 2:
                    System.out.print("Enter ID of employee to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter new Name: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Enter new Salary: ");
                    double updateSalary = scanner.nextDouble();
                    updateEmployee(updateId, updateName, updateSalary);
                    break;

                case 3:
                    System.out.print("Enter ID of employee to remove: ");
                    int removeId = scanner.nextInt();
                    removeEmployee(removeId);
                    break;

                case 4:
                    System.out.print("Enter ID of employee to search: ");
                    int searchId = scanner.nextInt();
                    searchEmployee(searchId);
                    break;

                case 5:
                    displayEmployees();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
