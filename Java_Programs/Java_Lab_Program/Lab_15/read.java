import java.io.FileInputStream;
import java.io.FileOutputStream;

public class read {
    public static void main(String[] args) {
        
        try{
            
    FileInputStream fin=new FileInputStream("D:/MOHIT1/FILE3.txt");
            
             int i;

             while ((i=fin.read()) != -1) {
                System.out.println((char)i);
             }

             fin.close();

        }catch(Exception ex){
            System.out.println(ex);
        }



    }
}
