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