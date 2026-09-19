public class Maximum_Score_After_Splitting_a_String_Question_1422_2 {

    public static int maxScore(String s) {

        int totalOnes = 0;

        // Count total 1s
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                totalOnes++;
            }
        }

        int leftZeros = 0;
        int rightOnes = totalOnes;
        int maxScore = 0;

        // Move the split from left to right
        // Stop at length - 1 because right must be non-empty
        for (int i = 0; i < s.length() - 1; i++) {

            char ch = s.charAt(i);

            if (ch == '0') {
                // 0 moves into left
                leftZeros++;
            } else {
                // 1 moves out of right
                rightOnes--;
            }

            int currentScore = leftZeros + rightOnes;

            maxScore = Math.max(maxScore, currentScore);
        }

        return maxScore;
    }

    public static void main(String[] args) {

        // Static Input
        String s = "011101";

        int result = maxScore(s);

        System.out.println("String: " + s);
        System.out.println("Maximum Score: " + result);
    }
}