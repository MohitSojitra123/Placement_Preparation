import java.util.*;

public class Unique_3_Digit_Even_Numbers_Question_3483 {

    public static int totalNumbers(int[] digits) {

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < digits.length; i++) {

            if (digits[i] == 0) {
                continue;
            }

            for (int j = 0; j < digits.length; j++) {

                for (int k = 0; k < digits.length; k++) {

                    if (i == j || i == k || j == k) {
                        continue;
                    }

                    if (digits[k] % 2 != 0) {
                        continue;
                    }

                    int number = digits[i] * 100
                               + digits[j] * 10
                               + digits[k];

                    set.add(number);
                }
            }
        }

        return set.size();
    }

    public static void main(String[] args) {

        // Static Input
        int[] digits = {1, 2, 3, 4};

        // Call method
        int result = totalNumbers(digits);

        // Print answer
        System.out.println("Answer = " + result);
    }
}