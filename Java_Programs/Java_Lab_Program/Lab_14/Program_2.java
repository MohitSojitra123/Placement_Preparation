import java.io.*;

public class Program_2 {
    public static void main(String[] args) {

     
        String inputFile = "file1.txt";
        String outputFile = "file2.txt";

        BufferedReader br = null;
        PrintWriter pw = null;

        int count = 0; 

        try {
            br = new BufferedReader(new FileReader(inputFile));
            pw = new PrintWriter(new FileWriter(outputFile));

            String line;

            while ((line = br.readLine()) != null) {

       
                String replacedLine = line.replace("word1", "word2");

           
                int diff = (line.length() - replacedLine.length()) / "word1".length();
                count += diff;

                pw.println(replacedLine);
            }

            System.out.println("Replacements completed.");
            System.out.println("Total replacements: " + count);
        }
        catch (FileNotFoundException e) {
            System.out.println("Error: Input file not found!");
        }
        catch (IOException e) {
            System.out.println("Error while reading or writing file.");
        }
        finally {
            try {
                if (br != null) br.close();
                if (pw != null) pw.close();
            } catch (IOException e) {
                System.out.println("Error closing files.");
            }
        }
    }
}
