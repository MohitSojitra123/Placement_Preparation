// An Anonymous Inner Class is a class without a name that is declared and instantiated at the same time.

// To provide one-time implementation of a class or interface without creating a separate class.

// Characteristics of Anonymous Inner Class
// No class name.
// One-time use.
// Declared and instantiated together.
// Reduces code length.
// Can access outer class members.
// Useful for event handling.
// Common in GUI applications.
// Common in multithreading.

interface Message {
    void show();
}

public class Inner_Class {

    public static void main(String[] args) {

        Message m = new Message() {

            public void show() {

                System.out.println("Hello From Anonymous Class");
            }
        };

        m.show();
    }
}