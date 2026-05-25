import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Student {
    int studentID;
    String studentName;
    int studentRollNo;
    float studentSPI;

    Student(int id, String name, int roll, float spi) {
        studentID = id;
        studentName = name;
        studentRollNo = roll;
        studentSPI = spi;
    }

    public void display() {
        System.out.println("ID: " + studentID);
        System.out.println("Name: " + studentName);
        System.out.println("Roll No: " + studentRollNo);
        System.out.println("SPI: " + studentSPI);
        System.out.println("---------------------------");
    }
}

public class Program_4 {
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

        
        Collections.sort(list, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return Float.compare(s1.studentSPI, s2.studentSPI); // ascending order
            }
        });

        System.out.println("\n===== Students Sorted by SPI =====");
        for (Student s : list) {
            s.display();
        }

        sc.close();
    }
}
