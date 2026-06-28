import java.util.Scanner;

public class Smith_Number {

    // Function to calculate digit sum
    static int digitSum(int num) {
        int sum = 0;
        while(num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    // Function to check prime
    static boolean isPrime(int num) {
        if(num < 2) {
            return false;
        }
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number : ");

        int num = sc.nextInt();

        int temp = num;

        // Prime numbers are not Smith Numbers
        if(isPrime(num)) {

            System.out.println("Not Smith Number");

            return;
        }

        int originalDigitSum = digitSum(num);

        int factorDigitSum = 0;

        // Prime factorization
        for(int i = 2; i <= num; i++) {

            while(num % i == 0) {

                factorDigitSum += digitSum(i);

                num /= i;
            }
        }

        if(originalDigitSum == factorDigitSum) {

            System.out.println(temp + " is Smith Number");

        } else {

            System.out.println(temp + " is Not Smith Number");
        }
    }
}