// The finalize() method is a method of the Object class.
// It is called by the Garbage Collector before removing an object from memory.

// Purpose of finalize() Method
// The purpose of finalize() is:

// Perform cleanup activities.
// Release resources before object destruction.
// Close files.
// Close database connections.
// Release network resources.

// finalize() is used to perform cleanup work before an object is removed from memory.

// finalize() Method

// The finalize() method belongs to the Object class and is called by the Garbage Collector before removing an object from memory. It is used for cleanup activities such as closing files or releasing resources.


class Gardage_Collection {

    public static void main(String[] args) {

        Gardage_Collection s1 = new Gardage_Collection();

        s1 = null;

        System.gc();

        System.out.println("Object Eligible For GC");
    }
}


// Garbage Collection

// Garbage Collection is an automatic memory management mechanism in Java that removes unreachable objects from heap memory and frees memory resources.


// Characteristics of Garbage Collection
// Automatic.
// Managed by JVM.
// Works on heap memory.
// Removes unreachable objects.
// Prevents memory leaks.
// Improves memory utilization.
// Runs in background.
// No manual memory management required.