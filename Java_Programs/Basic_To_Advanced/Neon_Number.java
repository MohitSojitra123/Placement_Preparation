import java.util.Scanner;

public class Neon_Number {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number : ");
        int num = sc.nextInt();

        int square = num * num;

        int sum = 0;

        while(square > 0) {

            int digit = square % 10;

            sum = sum + digit;

            square = square / 10;
        }

        if(sum == num) {
            System.out.println(num + " is Neon Number");
        } else {
            System.out.println(num + " is Not Neon Number");
        }
    }
}