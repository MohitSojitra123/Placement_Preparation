public class Ugly_Number_Question_26_1 {
    public static boolean isUgly(int n) {

        if (n <= 0) {
            return false;
        }

        while (n % 2 == 0) {
            n /= 2;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        while (n % 5 == 0) {
            n /= 5;
        }

        return n == 1;
    }

    public static void main(String[] args) {
        int n = 30;

        if (isUgly(n)) {
            System.out.println("Ugly Number");
        } else {
            System.out.println("Not an Ugly Number");
        }
    }
}