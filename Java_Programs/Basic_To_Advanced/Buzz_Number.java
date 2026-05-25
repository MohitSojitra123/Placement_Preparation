import java.util.Scanner;

public class Buzz_Number {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number : ");
        int num = sc.nextInt();

        if(num % 10 == 7 || num % 7 == 0) {

            System.out.println(num + " is Buzz Number");

        } else {

            System.out.println(num + " is Not Buzz Number");
        }
    }
}