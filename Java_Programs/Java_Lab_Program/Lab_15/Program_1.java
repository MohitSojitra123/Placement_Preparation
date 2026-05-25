import java.io.*;
import java.util.*;

class Student {
    int roll;
    String name;
    int marks;

    Student(int roll, String name, int marks) {
        this.roll = roll;
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return roll + "," + name + "," + marks;
    }
}

public class Program_1 {

    // static String fileName = "students.txt";

    public static void addStudent(Student s) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("D:/MOHIT1/FILE1", true))) {
            bw.write(s.toString());
            bw.newLine();
            System.out.println("Student added successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    public static void displayStudents() {
        try (BufferedReader br = new BufferedReader(new FileReader("D:/MOHIT1/FILE1"))) {
            String line;
            System.out.println("\n--- Student Records ---");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("------------------------");
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }


    public static void searchStudent(int rollNo) {
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader("D:/MOHIT1/FILE1"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int roll = Integer.parseInt(data[0]);

                if (roll == rollNo) {
                    System.out.println("\nStudent Found: " + line);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Student not found.");
            }

        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }


    public static void deleteStudent(int rollNo) {
        File inputFile = new File("D:/MOHIT1/FILE1");
        File tempFile = new File("temp.txt");

        boolean deleted = false;

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int roll = Integer.parseInt(data[0]);

                if (roll == rollNo) {
                    deleted = true;
                    continue; 
                }
                bw.write(line);
                bw.newLine();
            }
        }
        catch (IOException e) {
            System.out.println("Error processing file.");
            return;
        }


        inputFile.delete();
        tempFile.renameTo(inputFile);

        if (deleted)
            System.out.println("Student deleted successfully.");
        else
            System.out.println("Student not found.");
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Student Manager =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll: ");
                    int roll = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    int marks = sc.nextInt();

                    addStudent(new Student(roll, name, marks));
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    System.out.print("Enter Roll to Search: ");
                    int r = sc.nextInt();
                    searchStudent(r);
                    break;

                case 4:
                    System.out.print("Enter Roll to Delete: ");
                    int rd = sc.nextInt();
                    deleteStudent(rd);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
