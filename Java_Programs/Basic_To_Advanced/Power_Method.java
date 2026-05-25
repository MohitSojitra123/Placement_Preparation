import java.util.Scanner;

public class Power_Method {
    public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);

          System.out.println("Enter X Number To Find The Power");
          int x=sc.nextInt();

          System.out.println("Enter Y Number To Find The Power");
          int y=sc.nextInt();

          int ans1=1;

          for(int i=1; i<=y; i++){
              ans1*=x;
          }

          System.out.println("----------------------------");
          System.out.println("Using Multiplecation");
          System.out.println("----------------------------");
          System.out.println("Ans => "+ans1);
          System.out.println("----------------------------");
 
          int temp=0,result=1;

          for(int i=1; i<=y; i++){
                temp=0;  
            for(int j=1; j<=x; j++){
                 temp+=result;
              }
                result=temp;
          }

         System.out.println("----------------------------");
          System.out.println("Without Multiplecation");
          System.out.println("----------------------------");
          System.out.println("Ans => "+result);
          System.out.println("----------------------------");


    }
}
