package Day_1;
import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
          
        Scanner sc=new Scanner(System.in);

          int num1,num2;

          System.out.println("Enter Number 1 : ");
           num1=sc.nextInt();

           System.out.println("Enter Number 2 : ");
           num2=sc.nextInt();

           int GCD=0;

           for(int i=1; i<=num1 && i<=num2; i++){
            if(num1%i==0 && num2%i==0){
                GCD=i;
            }
           }

           System.out.println(GCD);

    }
}
