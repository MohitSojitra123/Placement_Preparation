public class Check_Balanced_String_Question_3340 {

    public static boolean isBalanced(String num) {

        int odd_sum = 0;
        int even_sum = 0;

        for (int i = 0; i < num.length(); i++) {
            if (i % 2 == 0) {
                odd_sum += num.charAt(i) - '0';
            } else {
                even_sum += num.charAt(i) - '0';
            }
        }

        return odd_sum == even_sum;
    }

    public static void main(String[] args) {

        String num = "1230"; // Static Input

        boolean result = isBalanced(num);

        System.out.println("Input: " + num);
        System.out.println("Is Balanced? " + result);
    }
}