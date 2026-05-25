// Write a Java program to create a class called Employee with a name, job title, and salary
// attributes, and methods to calculate and update salary.

import java.util.Scanner;


class Employee {
    // Attributes
    private String name;
    private String jobTitle;
    private double salary;

    // Constructor
    public Employee(String name, String jobTitle, double salary) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }

    // Method to display employee details
    public void displayInfo() {
        System.out.println("Employee Name: " + name);
        System.out.println("Job Title: " + jobTitle);
        System.out.println("Current Salary: " + salary);
        System.out.println("--------------------------------");
    }

    // Method to calculate yearly salary
    public double calculateYearlySalary() {
        return salary * 12;
    }

    // Method to update salary (increase or decrease)
    public void updateSalary(double amount) {
        salary += amount;
        System.out.println("Salary updated successfully!");
        System.out.println("New Salary: " + salary);
    }
}

public class Program_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input employee details
        System.out.print("Enter employee name: ");
        String name = sc.nextLine();

        System.out.print("Enter job title: ");
        String jobTitle = sc.nextLine();

        System.out.print("Enter monthly salary: ");
        double salary = sc.nextDouble();

        // Create Employee object
        Employee emp = new Employee(name, jobTitle, salary);

        // Display initial details
        System.out.println("\n--- Employee Details ---");
        emp.displayInfo();

        // Calculate yearly salary
        System.out.println("Yearly Salary: " + emp.calculateYearlySalary());

        // Update salary
        System.out.print("\nEnter amount to increase/decrease salary: ");
        double amount = sc.nextDouble();
        emp.updateSalary(amount);

        // Final info
        System.out.println("\n--- Updated Employee Details ---");
        emp.displayInfo();

        sc.close();
    }
}
