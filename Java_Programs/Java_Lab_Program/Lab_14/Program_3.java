import java.io.*;

public class Program_3 {
    public static void main(String[] args) {

  
        if (args.length == 0) {
            System.out.println("Please provide file name as command-line argument.");
            return;
        }

        String fileName = args[0];
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            int ch;

 
            while ((ch = br.read()) != -1) {
                if (ch == '5') {   
                    count++;
                }
            }

            System.out.println("Digit '5' occurred " + count + " times.");

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found!");
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}
