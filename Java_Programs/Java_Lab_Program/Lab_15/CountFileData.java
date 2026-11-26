import java.io.BufferedReader;
import java.io.FileReader;

public class CountFileData {
    public static void main(String[] args) {
        int charCount = 0;
        int wordCount = 0;
        int lineCount = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("D:/MOHIT1/FILE3.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                lineCount++;                         // Count line

                charCount += line.length();          // Count characters

                String words[] = line.trim().split("\\s+");
                if (!line.trim().equals("")) {
                    wordCount += words.length;       // Count words
                }
            }

            br.close();

            System.out.println("Total Lines      : " + lineCount);
            System.out.println("Total Words      : " + wordCount);
            System.out.println("Total Characters : " + charCount);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
