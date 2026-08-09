public class Smallest_Divisible_Digit_Product_I_Question_3345 {

    public static int smallestNumber(int n, int t) {

        while (true) {

            int digit_product = 1;
            int current = n;

            while (n != 0) {
                digit_product *= n % 10;
                n /= 10;
            }

            if (digit_product % t == 0) {
                return current;
            }

            current += 1;
            n = current;
        }
    }

    public static void main(String[] args) {

        // Static Input
        int n = 10;
        int t = 2;

        int result = smallestNumber(n, t);

        System.out.println("n = " + n);
        System.out.println("t = " + t);
        System.out.println("Smallest Number = " + result);
    }
}