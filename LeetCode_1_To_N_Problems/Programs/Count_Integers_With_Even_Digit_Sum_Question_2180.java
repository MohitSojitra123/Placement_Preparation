public class Count_Integers_With_Even_Digit_Sum_Question_2180 {

    public static int DigitSum(int i) {

        int sum = 0;

        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }

        return sum;
    }

    public static int countEven(int num) {

        int count = 0;

        for (int i = 1; i <= num; i++) {

            if (i < 10 && i % 2 == 0) {
                count++;
            } else {
                if (DigitSum(i) % 2 == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        // Static Input
        int num = 30;

        // Function Call
        int result = countEven(num);

        // Print Result
        System.out.println("Input: " + num);
        System.out.println("Count of Even Digit Sum Numbers: " + result);
    }
}