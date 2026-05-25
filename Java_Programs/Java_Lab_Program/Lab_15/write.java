import java.io.FileOutputStream;
import java.util.Scanner;

public class write {
    public static void main(String[] args)  {
        
        try{
            FileOutputStream fout=new FileOutputStream("D:/MOHIT1/FILE3.txt");
            
            System.out.println("Enter Your Name : ");
            Scanner sc=new Scanner(System.in);
            String s=sc.nextLine();
            byte b[]=s.getBytes();
            fout.write(b);
            fout.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
