// An Anonymous Inner Class is an inner class without a name.

// It is declared and instantiated at the same time.

// Simple Definition
// A class that has no name and is used only once is called an Anonymous Inner Class.


// Characteristics of Anonymous Inner Class
// No class name.
// Used once.
// Created and instantiated together.
// Can extend a class.
// Can implement an interface.
// Useful for event handling.





interface Message {

    void show();
}

public class Anonoymous_Class {

    public static void main(String[] args) {

        Message m = new Message() {

            public void show() {

                System.out.println("Hello Java");
            }
        };

        m.show();
    }
}