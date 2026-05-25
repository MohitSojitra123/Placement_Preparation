import java.io.*;

public class Program_1 {
    public static void main(String[] args) {
        
        BufferedReader reader = null;

        try {
          
            File file = new File("D:/MOHIT1/FILE2.txt");

       
            if (!file.exists()) {
                throw new FileNotFoundException("File not found!");
            }

            reader = new BufferedReader(new FileReader(file));

            int charCount = 0;
            int wordCount = 0;
            int lineCount = 0;

            String line;


            while ((line = reader.readLine()) != null) {
                lineCount++;   
                charCount += line.length();  

                String[] words = line.trim().split(" ");

                if (!line.trim().equals("")) {
                    wordCount += words.length;  
                }
            }


            System.out.println("Number of Lines: " + lineCount);
            System.out.println("Number of Words: " + wordCount);
            System.out.println("Number of Characters: " + charCount);

        } 
        catch (FileNotFoundException e) {
            System.out.println("Error: The file does not exist.");
        }
        catch (IOException e) {
            System.out.println("Error reading the file.");
        } 
        finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing the file.");
            }
        }
    }
}
