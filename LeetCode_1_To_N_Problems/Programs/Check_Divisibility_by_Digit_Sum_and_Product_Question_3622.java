public class Check_Divisibility_by_Digit_Sum_and_Product_Question_3622 {

    public static boolean checkDivisibility(int n) {

        int n2 = n;
        int digit_sum = 0;
        int digit_product = 1;

        while (n2 != 0) {
            digit_sum += n2 % 10;
            digit_product *= n2 % 10;

            n2 /= 10;
        }

        return n % (digit_sum + digit_product) == 0;
    }

    public static void main(String[] args) {

        // Static Input
        int n = 23;

        boolean result = checkDivisibility(n);

        System.out.println("Number: " + n);
        System.out.println("Is Divisible: " + result);
    }
}