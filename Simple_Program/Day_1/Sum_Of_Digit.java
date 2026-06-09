package Day_1;
import java.util.Scanner;

public class Sum_Of_Digit {
    public static void main(String[] args) {
        
          Scanner sc=new Scanner(System.in);

          System.out.println("Enter Number : ");
          int num=sc.nextInt();


          int sum=0;

          while (num!=0) {
              sum+=num%10;
            num/=10;
          }

          System.out.println("Sum : "+sum);


    }
}
