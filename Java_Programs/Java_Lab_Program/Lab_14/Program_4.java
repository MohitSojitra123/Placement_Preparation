import java.io.*;
import java.util.*;

class Student {
    int roll;
    String name;
    float spi;

    Student(int roll, String name, float spi) {
        this.roll = roll;
        this.name = name;
        this.spi = spi;
    }

    @Override
    public String toString() {
        return roll + "," + name + "," + spi;
    }
}

public class Program_4 {
    
    static String fileName = "students.dat";


    public static void addStudent(Student s) {
        try (FileOutputStream fos = new FileOutputStream(fileName, true)) {
            String data = s.toString() + "\n";
            fos.write(data.getBytes());
            System.out.println("Student added successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }


    public static void displayStudents() {
        try (FileInputStream fis = new FileInputStream(fileName)) {

            System.out.println("\n--- Student Records ---");

            int ch;
            StringBuilder sb = new StringBuilder();

            while ((ch = fis.read()) != -1) {
                sb.append((char) ch);
            }

            String content = sb.toString();

            if (content.trim().equals("")) {
                System.out.println("No student data found.");
                return;
            }

  
            String[] lines = content.split("\n");

            for (String line : lines) {
                System.out.println(line);
            }

            System.out.println("------------------------");

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Student Manager =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll: ");
                    int roll = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter SPI: ");
                    float spi = sc.nextFloat();

                    addStudent(new Student(roll, name, spi));
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 3);

        sc.close();
    }
}

