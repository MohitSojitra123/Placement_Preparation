package Day_1;
import java.util.Scanner;

public class Two_and_Three_Divide_or_NotDivide {
    public static void main(String[] args) {
        
          Scanner sc=new Scanner(System.in);

          System.out.println("Enter Number 1 : ");
          int num1=sc.nextInt();

          System.out.println("Enter Number 2 : ");
          int num2=sc.nextInt();

          for(int i=num1; i<=num2; i++){
               if(i%2==0 && i%3!=0){
                     System.out.print(i+" ");
               }
          }

    }
}
