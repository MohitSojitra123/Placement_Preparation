// Write a Java program to create a class called Employee with a name, job title, and salary
// attributes, and methods to calculate and update salary.

import java.util.Scanner;


class Employee {

    private String name;
    private String jobTitle;
    private double salary;


    public Employee(String name, String jobTitle, double salary) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }

    public void displayInfo() {
        System.out.println("Employee Name: " + name);
        System.out.println("Job Title: " + jobTitle);
        System.out.println("Current Salary: " + salary);
        System.out.println("--------------------------------");
    }
    
    public double calculateYearlySalary() {
        return salary * 12;
    }

    public void updateSalary(double amount) {
        salary += amount;
        System.out.println("Salary updated successfully!");
        System.out.println("New Salary: " + salary);
    }
}

public class Program_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter employee name: ");
        String name = sc.nextLine();

        System.out.print("Enter job title: ");
        String jobTitle = sc.nextLine();

        System.out.print("Enter monthly salary: ");
        double salary = sc.nextDouble();

        Employee emp = new Employee(name, jobTitle, salary);

        System.out.println("\n--- Employee Details ---");
        emp.displayInfo();

        System.out.println("Yearly Salary: " + emp.calculateYearlySalary());

    System.out.print("\nEnter amount to increase/decrease salary: ");
        double amount = sc.nextDouble();
        emp.updateSalary(amount);

        System.out.println("\n--- Updated Employee Details ---");
        emp.displayInfo();

        sc.close();
    }
}
