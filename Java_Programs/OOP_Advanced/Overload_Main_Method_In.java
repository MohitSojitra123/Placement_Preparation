public class Overload_Main_Method_In {

    // =========================================
    // DEFAULT / ORIGINAL MAIN METHOD
    // JVM starts execution from this method
    // =========================================
    public static void main(String[] args) {

        System.out.println("By Default Main Method");

        // Calling overloaded main() method
        Overload_Main_Method_In.main("Mohit");
    }


    // =========================================
    // OVERLOADED MAIN METHOD
    // This method is NOT called automatically by JVM
    // because its parameter is String instead of String[]
    // =========================================
    public static void main(String name) {

        System.out.println("My Name : " + name);
    }
}