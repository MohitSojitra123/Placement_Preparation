import java.io.FileOutputStream;
import java.util.Scanner;

public class append {
    public static void main(String[] args) {
        try {
            // Append mode: TRUE
            FileOutputStream fout = new FileOutputStream("D:/MOHIT1/FILE3.txt", true);

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter text to append: ");
            String s = sc.nextLine();

            // Add newline before appending (optional)
            s = "\n" + s;

            byte b[] = s.getBytes();
            fout.write(b);

            fout.close();
            System.out.println("Data appended successfully!");

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
