import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int studentID;
    String studentName;
    int studentRollNo;
    float studentSPI;

    Student(int id, String name, int roll, float spi) {
        this.studentID = id;
        this.studentName = name;
        this.studentRollNo = roll;
        this.studentSPI = spi;
    }

    public void display() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Student Name: " + studentName);
        System.out.println("Student Roll No: " + studentRollNo);
        System.out.println("Student SPI: " + studentSPI);
        System.out.println("-----------------------------");
    }
}

public class Program_3 {
    public static void main(String[] args) {

        ArrayList<Student> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); 
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Student " + (i + 1));

            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Student Roll No: ");
            int roll = sc.nextInt();

            System.out.print("Enter Student SPI: ");
            float spi = sc.nextFloat();
            sc.nextLine();

            list.add(new Student(id, name, roll, spi));
        }

        System.out.println("\n===== Displaying Student List =====");
        for (Student s : list) {
            s.display();
        }

        sc.close();
    }
}
