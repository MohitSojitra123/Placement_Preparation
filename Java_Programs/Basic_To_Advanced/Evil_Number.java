import java.util.Scanner;

public class Evil_Number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number : ");
        int num = sc.nextInt();

        int temp = num;
        int count = 0;

        while (num > 0) {
            int rem = num % 2;
            if (rem == 1) {
                count++;
            }
            num = num / 2;
        }

        if (count % 2 == 0) {
            System.out.println(temp + " is Evil Number");
        } else {
            System.out.println(temp + " is Not Evil Number");
        }
    }
} 
