import java.util.Scanner;

public class Lucas_Series {
     public static void main(String[] args) {
              // Generate Lucas series

              Scanner sc=new Scanner(System.in);

              System.out.println("Enter Nth Number Print In Lucas Series....");
              int user=sc.nextInt();

              int a=2;
              int b=1;
              int c=0;

              System.out.print(a+" "+b+" ");

              for(int i=1; i<=user; i++){
                   c=a+b;
                   a=b;
                   b=c;
                   System.out.print(c+" ");
              }
              
     }
}

