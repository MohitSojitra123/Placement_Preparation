package Day_1;
import java.util.Scanner;

public class Count_Number_Of_Even_Digit {
    public static void main(String[] args) {
        
          Scanner sc=new Scanner(System.in);

          System.out.println("Enter Number : ");
          int num=sc.nextInt();


          int even_count=0;

          while (num!=0) {
            if((num%10)%2==0){
                even_count++;
            }
            num/=10;
          }

          System.out.println("Even Count "+even_count);

    }
}
