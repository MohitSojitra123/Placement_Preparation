// Write a Java program to create an interface Shape with the getArea() method. Create
// three classes Rectangle, Circle, and Triangle that implement the Shape interface.
// Implement the getArea() method for each of the three classes. [B]


interface Shape {
    double getArea(); 
}


class Rectangle implements Shape {
    private double length;
    private double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getArea() {
        return length * width;
    }
}


class Circle implements Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }
}


class Triangle implements Shape {
    private double base;
    private double height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double getArea() {
        return 0.5 * base * height;
    }
}


public class Program_4 {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(10, 5);
        Shape circle = new Circle(7);
        Shape triangle = new Triangle(6, 8);

        System.out.println("Area of Rectangle: " + rectangle.getArea());
        System.out.println("Area of Circle: " + circle.getArea());
        System.out.println("Area of Triangle: " + triangle.getArea());
    }
}
