import java.util.Scanner;

public class Tetrahedral_Number {
    public static void main(String[] args) {

     Scanner sc=new Scanner(System.in);


      System.out.println("Enter Any Number To Print Nth Term Tetrahedral Number....");
       int user=sc.nextInt();

       int calculation=0;

       for(int i=1; i<=user; i++){
              calculation=((i*((i+1)*(i+2)))/6);
              System.out.println("T"+i +"  => "+calculation+"  ");
       }

    }
}
