import java.util.Arrays;

public class Counting_Bits_Question_338 {

    public static String convertToBinary(int num) {

        String binary = "";

        while (num > 0) {

            int remainder = num % 2;

            binary = remainder + binary;

            num = num / 2;
        }

        return binary;
    }

    public static int countOnes(String binary) {

        int count = 0;

        for (int i = 0; i < binary.length(); i++) {

            if (binary.charAt(i) == '1') {
                count++;
            }
        }

        return count;
    }

    public static int[] countBits(int n) {

        int[] ans = new int[n + 1];

        ans[0] = 0;

        for (int i = 1; i <= n; i++) {

            String binary = convertToBinary(i);

            int oneCount = countOnes(binary);

            ans[i] = oneCount;
        }

        return ans;
    }

    public static void main(String[] args) {

        // Static input
        int n = 5;

        int[] ans = countBits(n);

        System.out.println(Arrays.toString(ans));
    }
}