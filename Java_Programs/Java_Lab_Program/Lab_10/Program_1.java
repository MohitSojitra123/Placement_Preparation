// The  abstract  vegetable  class  has three  subclasses  named  Potato,  Brinjal and  Tomato. 
// Write a java program that demonstrates how to establish this class hierarchy. Declare 
// one instance variable of type String that indicates the color of a vegetable. Create and 
// display instances of these objects. Override the to_String1() method of object to return a 
// string with the name of vegetable and its color. [A]

package Lab_10;

abstract class Vegetable { 
    String color;

    Vegetable(String color) {
        this.color = color;
    }

    abstract void to_String1(String veg_nm); 
}

class Potato extends Vegetable {
    Potato(String color) {
        super(color);
    }

    void to_String1(String veg_name) {
        System.out.println("Vegetable Name: " + veg_name);
        System.out.println("Color: " + super.color);
    }
}

class Brinjal extends Vegetable {
    Brinjal(String color) {
        super(color);
    }

    void to_String1(String veg_name) {
        System.out.println("Vegetable Name: " + veg_name);
        System.out.println("Color: " + super.color);
    }
}

class Tomato extends Vegetable {
    Tomato(String color) {
        super(color);
    }

    void to_String1(String veg_name) {
        System.out.println("Vegetable Name: " + veg_name);
        System.out.println("Color: " + super.color);
    }
}

public class Program_1 {
    public static void main(String[] args) {

        Vegetable vg1[] = new Vegetable[3];

        vg1[0] = new Potato("Sky Blue");
        vg1[1] = new Brinjal("Purple");
        vg1[2] = new Tomato("Red");

        vg1[0].to_String1("Potato");
        System.out.println();
        vg1[1].to_String1("Brinjal");
        System.out.println();
        vg1[2].to_String1("Tomato");
    }
}
