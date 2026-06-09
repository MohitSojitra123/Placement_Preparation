package Day_1;
import java.util.Scanner;

public class Factorial_Number {
    public static void main(String[] args) {
        
          Scanner sc=new Scanner(System.in);

          System.out.println("Enter Number To Find Factorial : ");
          int n=sc.nextInt();

          int fact=1;

          for(int i=1; i<=n; i++){
            fact*=i;
          }

          System.out.println("Factorial Number : "+fact);

    }
}
