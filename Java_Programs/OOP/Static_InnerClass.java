public class College {

    static class Department {

        void display() {

            System.out.println("Computer Department");
        }
    }
}

public class Static_InnerClass {

    public static void main(String[] args) {

        College.Department d =
                new College.Department();

        d.display();
    }
} {
    
}
