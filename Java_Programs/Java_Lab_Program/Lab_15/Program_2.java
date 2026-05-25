import java.io.File;

public class Program_2 {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Please enter a file or directory name.");
            return;
        }

        
        File f = new File(args[0]);

      
        if (!f.exists()) {
            System.out.println("The given name does not exist.");
            return;
        }

      
        if (f.isFile()) {
            System.out.println(args[0] + " is a File.");
            System.out.println("Size: " + f.length() + " bytes");
        }
     
        else if (f.isDirectory()) {
            System.out.println(args[0] + " is a Directory.");
            System.out.println("Files inside directory:");

            String[] files = f.list();
            for (String filename : files) {
                System.out.println(filename);
            }
        }
    }
}
