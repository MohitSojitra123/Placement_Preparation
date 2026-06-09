package Day_1;
import java.util.Scanner;

public class Multiply_Without_Operator {
   public static void main(String[] args) {
    
    Scanner sc=new Scanner(System.in);

    System.out.println("Enter x : ");
    int x=sc.nextInt();

    System.out.println("Enter y : ");
    int y=sc.nextInt();

    int ans=0;

    for(int i=1; i<=x; i++){
       ans=ans+y;
    }

    System.out.println(ans);

   }    
}
