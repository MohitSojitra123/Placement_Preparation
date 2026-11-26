public class  Power_of_Four_Question_342 {

    public static boolean isPowerOfFour(int n) {

        if (n <= 0) {
            return false;
        }

        while (n % 4 == 0) {
            n /= 4;
        }

        return n == 1;
    }

    public static void main(String[] args) {

        int n = 16;  

        boolean result = isPowerOfFour(n);

        System.out.println(result);
    }
}
