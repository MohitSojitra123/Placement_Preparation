package Lab_10;

// Write  a  Java  program  to  create  an  abstract  class  Vehicle  with  abstract  methods 
// startEngine() and stopEngine(). Create subclasses Car and Motorcycle that extend the 
// Vehicle class and implement the respective methods to start and stop the engines for 
// each vehicle type.[B] 


abstract class Vehicle {
    protected String vehicleName;


    public Vehicle(String vehicleName) {
        this.vehicleName = vehicleName;
    }


    public abstract void startEngine();
    public abstract void stopEngine();
}


class Car extends Vehicle {
    public Car(String vehicleName) {
        super(vehicleName);
    }

    @Override
    public void startEngine() {
        System.out.println(vehicleName + " engine started. Vroom Vroom!");
    }

    @Override
    public void stopEngine() {
        System.out.println(vehicleName + " engine stopped. Silence...");
    }
}

class Motorcycle extends Vehicle {
    public Motorcycle(String vehicleName) {
        super(vehicleName);
    }

    @Override
    public void startEngine() {
        System.out.println(vehicleName + " engine started. Braap Braap!");
    }

    @Override
    public void stopEngine() {
        System.out.println(vehicleName + " engine stopped. Silence...");
    }
}

public class VehicleDemo {
    public static void main(String[] args) {
        Vehicle car = new Car("Toyota ");
        Vehicle bike = new Motorcycle("Hero Honda");

        // Start engines
        car.startEngine();
        bike.startEngine();

        System.out.println();

        // Stop engines
        car.stopEngine();
        bike.stopEngine();
    }
}
