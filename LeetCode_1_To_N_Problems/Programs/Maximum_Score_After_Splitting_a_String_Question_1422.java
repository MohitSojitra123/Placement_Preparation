public class Maximum_Score_After_Splitting_a_String_Question_1422 {

    public static int maxScore(String s) {

        int max_count = 0;
        int current_count = 0;
        int zero_count = 0;
        int one_count = 0;

        for (int i = 0; i < s.length() - 1; i++) {

            String left = s.substring(0, i + 1);
            String right = s.substring(i + 1);

            zero_count = 0;
            one_count = 0;

            // Count zeros in left part
            for (char ch : left.toCharArray()) {
                if (ch == '0') {
                    zero_count++;
                }
            }

            // Count ones in right part
            for (char ch : right.toCharArray()) {
                if (ch == '1') {
                    one_count++;
                }
            }

            current_count = zero_count + one_count;

            max_count = Math.max(max_count, current_count);
        }

        return max_count;
    }

    public static void main(String[] args) {

        // Static Input
        String s = "011101";

        // Method call
        int result = maxScore(s);

        // Output
        System.out.println("String: " + s);
        System.out.println("Maximum Score: " + result);
    }
}