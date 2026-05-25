package Lab_9;

// 5 4. Design a class named MyPoint to represent a point with x- and y-coordinates. The 
// class contains: 
// The data fields x and y that represent the coordinates with getter methods. 
// 1. a no-arg constructor that creates a point (0, 0). 
// 2. a constructor that constructs a point with specified coordinates. 
// 3. a method named distance that returns the distance from this point to a specified 
// point of the MyPoint type. 
// 4. a method named distance that returns the distance from this point to another point 
// with specified x- and y-coordinates.Create a class named ThreeDPoint to model a 
// point in a three-dimensional space. Let ThreeDPoint be derived from MyPoint with 
// following additional features: 
// 1. A data fields named z that represents the z-coordinate. 
// 2.    A no-arg constructor that creates a point (0, 0, 0). 
// 3.   A constructor that constructs a point with three specified coordinates. 
// 4.   A get method that returns the z value. 
// 5.   Override the distance method to return the distance between two points in the 
// three-dimensional space. Write a program that creates two points (0, 0, 0) and (10, 
// 30, 25.5) and display the distance between the two points. [C]

// Class representing a 2D point
class MyPoint {
    // Data fields
    private double x;
    private double y;

    // No-arg constructor (0,0)
    public MyPoint() {
        this.x = 0;
        this.y = 0;
    }

    // Constructor with specified coordinates
    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Getter methods
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Method to calculate distance to another MyPoint object
    public double distance(MyPoint other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Method to calculate distance to specified coordinates
    public double distance(double x, double y) {
        double dx = this.x - x;
        double dy = this.y - y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}

// Class representing a 3D point, derived from MyPoint
class ThreeDPoint extends MyPoint {
    private double z; // Additional z-coordinate

    // No-arg constructor (0,0,0)
    public ThreeDPoint() {
        super(); // Calls MyPoint no-arg constructor
        this.z = 0;
    }

    // Constructor with specified coordinates
    public ThreeDPoint(double x, double y, double z) {
        super(x, y); // Calls MyPoint constructor
        this.z = z;
    }

    // Getter for z
    public double getZ() {
        return z;
    }

    // Override distance method for 3D points
    public double distance(ThreeDPoint other) {
        double dx = this.getX() - other.getX();
        double dy = this.getY() - other.getY();
        double dz = this.z - other.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }
}

// Main class to test
public class Program_5 {
    public static void main(String[] args) {
        // Create two 3D points
        ThreeDPoint p1 = new ThreeDPoint(); // (0,0,0)
        ThreeDPoint p2 = new ThreeDPoint(10, 30, 25.5);

        // Calculate distance between the two points
        double distance = p1.distance(p2);

        System.out.println("Distance between points (0,0,0) and (10,30,25.5): " + distance);
    }
}
