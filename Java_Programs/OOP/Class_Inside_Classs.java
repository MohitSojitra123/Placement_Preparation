// 1. Encapsulation
// Wrapping data and methods together and hiding data using private access modifiers.

// 2. Abstraction
// Showing essential information while hiding implementation details.

// 3. Inheritance
// Acquiring properties and methods of one class into another class.

// 4. Polymorphism
// One method behaving differently in different situations.


public class Class_Inside_Classs {

    class student {
        int roll_number;
        String name;
    }

    public static void main(String[] args) {

        Class_Inside_Classs obj = new Class_Inside_Classs();

        student s1 = obj.new student();

        s1.name = "Mohit";
        s1.roll_number = 101;

        System.out.println("Name : " + s1.name);
        System.out.println("Roll Number : " + s1.roll_number);
    }
}