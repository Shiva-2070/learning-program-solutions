class Employee {
    int id;
    String name;
    String job;
    double salary;
    
    Employee(int i, String n, String j, double s) {
        id = i;
        name = n;
        job = j;
        salary = s;
    }
}

public class EmployeeSystem {
    Employee[] employees = new Employee[10];
    int count = 0;
    
    void addEmployee(int id, String name, String job, double salary) {
        if (count < employees.length) {
            employees[count] = new Employee(id, name, job, salary);
            count++;
        } else {
            System.out.println("Full!");
        }
    }
    
    Employee search(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].id == id) {
                return employees[i];
            }
        }
        return null;
    }
    
    void showAll() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i].name);
        }
    }
    
    void delete(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].id == id) {
                // Shift remaining elements
                for (int j = i; j < count-1; j++) {
                    employees[j] = employees[j+1];
                }
                count--;
                return;
            }
        }
    }
    
    public static void main(String[] args) {
        EmployeeSystem es = new EmployeeSystem();
        es.addEmployee(1, "John", "Dev", 5000);
        es.addEmployee(2, "Alice", "Manager", 7000);
        es.showAll();
        es.delete(1);
        es.showAll();
    }
}