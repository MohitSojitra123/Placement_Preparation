package Day_1;
import java.util.Scanner;

public class LCM {
    public static void main(String[] args) {
           Scanner sc=new Scanner(System.in);       
 
          int num1,num2;
          
          System.out.println("Enter Number num1 : ");
         num1=sc.nextInt();

         System.out.println("Enter Number num2 : ");
         num2=sc.nextInt();


         int LCM=0;

         for(int i=2; ; i++){
              if(i%num1==0 && i%num2==0){
                   LCM=i;
                   break;
              }
         }

         System.out.println("LCM : "+LCM);

    }
}
