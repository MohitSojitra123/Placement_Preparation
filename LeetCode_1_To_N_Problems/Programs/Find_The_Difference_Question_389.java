public class Find_The_Difference_Question_389 {
    public static void main(String[] args) {

        String s = "abcd";
        String t = "abcde";

        int s_sum = 0;
        int t_sum = 0;

        for (int i = 0; i < s.length(); i++) {
            s_sum += (int) s.charAt(i);
        }

        for (int i = 0; i < t.length(); i++) {
            t_sum += (int) t.charAt(i);
        }

        int result = t_sum - s_sum;

        char extraChar = (char) result;

        System.out.println("Extra Character: " + extraChar);
    }
}