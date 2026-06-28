// Nested Class in Java
// Definition
// A Nested Class is a class declared inside another class.

// Simple Definition
// A class defined inside another class is called a Nested Class.

// Example

// class Bank {
//     class Account {

//     }
// }


// class Order {
//     class Item {

//     }
// }



// class Hospital {
//     class Patient {

//     }
// }



// class School {
//     class Student {

//     }
// }

public class Company1 {

    String companyName = "TCS";

    class Employee {

        void show() {

            System.out.println(companyName);
        }
    }
}

public class InnerClass {

    public static void main(String[] args) {

        Company1 c = new Company1();

        Company1.Employee e = c.new Employee();

        e.show();
    }
} {
    
}
