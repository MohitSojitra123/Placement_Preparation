package Lab_9;

// 2 Write a Java program to create a class called Employee with methods called work() and 
// getSalary(). Create a subclass called HRManager that overrides the work() method and 
// adds a new method called addEmployee().[A]


// Method Overriding

// Superclass Employee
class Employee {
    protected String name;
    protected double salary;


    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void work() {
        System.out.println(name + " is working on general tasks.");
    }

    public double getSalary() {
        return salary;
    }
}


class HRManager extends Employee {

    public HRManager(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void work() {
        System.out.println(name + " is managing HR tasks.");
    }

    public void addEmployee(String employeeName) {
        System.out.println("HR Manager " + name + " added a new employee: " + employeeName);
    }
}

public class Program_2 {
    public static void main(String[] args) {

        Employee emp = new Employee("Alice", 50000);
        System.out.println("Employee Details:");
        emp.work();
        System.out.println("Salary: $" + emp.getSalary());
        System.out.println();

        HRManager hr = new HRManager("Bob", 70000);
        System.out.println("HR Manager Details:");
        hr.work(); 
        System.out.println("Salary: $" + hr.getSalary());
        hr.addEmployee("Charlie"); 

    }
}
