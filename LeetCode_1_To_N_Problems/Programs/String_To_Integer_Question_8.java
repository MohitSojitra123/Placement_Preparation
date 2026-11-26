public class String_To_Integer_Question_8 {

    public static int myAtoi(String s) {

        int i = 0;
        int sign = 1;
        int result = 0;

        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        if (i < s.length()) {

            if (s.charAt(i) == '-') {
                sign = -1;
                i++;
            } else if (s.charAt(i) == '+') {
                i++;
            }
        }

        while (i < s.length() &&
               s.charAt(i) >= '0' &&
               s.charAt(i) <= '9') {

            int digit = s.charAt(i) - '0';

            if (result > (Integer.MAX_VALUE - digit) / 10) {

                if (sign == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }

            result = result * 10 + digit;

            i++;
        }

        return result * sign;
    }

    public static void main(String[] args) {

        // Static Input
        String s = "   -042";

        int result = myAtoi(s);

        System.out.println("Input  : \"" + s + "\"");
        System.out.println("Output : " + result);
    }
}