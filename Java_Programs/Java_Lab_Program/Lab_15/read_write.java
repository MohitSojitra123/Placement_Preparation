import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class read_write {
    public static void main(String[] args) {
        try {
       
            FileOutputStream fout = new FileOutputStream("D:/MOHIT1/FILE3.txt");

            System.out.print("Enter Your Name : ");
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();

            byte[] b = s.getBytes();
            fout.write(b);
            fout.close();
            System.out.println("Data Written Successfully!");

         
            FileInputStream fin = new FileInputStream("D:/MOHIT1/FILE3.txt");
            System.out.println("\nReading Data From File:");

            int i;
            while ((i = fin.read()) != -1) {
                System.out.print((char) i);
            }

            fin.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
