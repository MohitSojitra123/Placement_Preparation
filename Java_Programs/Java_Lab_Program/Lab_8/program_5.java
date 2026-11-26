// Write a Java program to create a class called House with private instance variables
// address, numberOfRooms, and area. Provide public getter and setter methods to access
// and modify these variables. Add a method called calculatePrice() that returns the price
// of the house based on its area and a price per square meter.[C]

import java.util.Scanner;

class House {
    private String address;
    private int numberOfRooms;
    private double area; 

    public House(String address, int numberOfRooms, double area) {
        this.address = address;
        this.numberOfRooms = numberOfRooms;
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double calculatePrice(double pricePerSquareMeter) {
        return area * pricePerSquareMeter;
    }

    public void displayDetails(double pricePerSquareMeter) {
        System.out.println("House Address: " + address);
        System.out.println("Number of Rooms: " + numberOfRooms);
        System.out.println("Area: " + area + " sq.m");
        System.out.println("Price: $" + calculatePrice(pricePerSquareMeter));
        System.out.println("-----------------------------------");
    }
}

public class program_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter house address: ");
        String address = sc.nextLine();

        System.out.print("Enter number of rooms: ");
        int rooms = sc.nextInt();

        System.out.print("Enter area of the house (in sq.m): ");
        double area = sc.nextDouble();

        System.out.print("Enter price per square meter: ");
        double pricePerSquareMeter = sc.nextDouble();

        House house = new House(address, rooms, area);

        System.out.println("\n--- House Details ---");
        house.displayDetails(pricePerSquareMeter);

        sc.close();
    }
}
