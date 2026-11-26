public class PlusOne_Question_66 {

    public static int[] plusOne(int[] digits) {

        // Start from last digit
        for (int i = digits.length - 1; i >= 0; i--) {

            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            // If digit is 9, make it 0
            digits[i] = 0;
        }

        // All digits are 9
        int[] result = new int[digits.length + 1];

        result[0] = 1;

        return result;
    }


    public static void main(String[] args) {

        int[] digits = {1, 2, 3};

        int[] ans = plusOne(digits);

        for(int i : ans) {
            System.out.print(i + " ");
        }
    }
}