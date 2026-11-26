// Write a program to convert temperature from Fahrenheit to Celsius. (Formula : c = f32*5/9 )
import java.util.Scanner;

public class Program_4 {
     public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);   

        System.out.println(  "Enter Temperature => ");
        int temp=sc.nextInt();

        double ans=(temp-32)*(5.0/9.0);

        System.out.println(ans);
     }
}
