import java.util.Scanner;

public class Tribonacci_Series {
    public static void main(String[] args) {

            Scanner sc=new Scanner(System.in);

            System.out.println("Enter Nth number For Print Tribonacci Serice...");
            int user=sc.nextInt();

            int a=0;
            int b=1;
            int c=1;
            int d=0;

            System.out.print(a + " " + " " + b + " " + c +" ");

            for(int i=1; i<user; i++){
                d=a+b+c;
                a=b;
                b=c;
                c=d;
                System.out.print(d+" ");
            } 
    }
}
