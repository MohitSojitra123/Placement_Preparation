public class Question_48_3 {

    public static void main(String[] args) {

        int nums[] = {1, 2, 3, 5, 6};

        int n = nums.length + 1;   // Original size including missing element

        int expectedSum = n * (n + 1) / 2;

        int actualSum = 0;

        // Single loop
        for (int num : nums) {
            actualSum += num;
        }

        int missing = expectedSum - actualSum;

        System.out.println("Missing Element = " + missing);
    }
} {
    
}
