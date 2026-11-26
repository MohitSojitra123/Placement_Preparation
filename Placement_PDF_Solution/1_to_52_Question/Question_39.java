// Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer. 
// The algorithm for myAtoi(string s) is as follows: 
// Whitespace: Ignore any leading whitespace (" "). 
// Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity is neither 
// present. 
// Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the 
// end of the string is reached. If no digits were read, then the result is 0. 
// Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to 
// remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater 
// than 231 - 1 should be rounded to 231 - 1. 
// Return the integer as the final result. 
// Input: s = " -042" 
// Output: -42 
// Explanation: 
// Step 1: "   -042" (leading whitespace is read and ignored) 
// Step 2: "   -042" ('-' is read, so the result should be negative) 
// Step 3: "   -042" ("042" is read in, leading zeros ignored in the result)

public class Question_39 {

    public static int myAtoi(String s) {

        int i = 0;
        int n = s.length();

        while (i < n && s.charAt(i) == ' ') {
            i++;
        }


        int sign = 1;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }

        long num = 0;

        while (i < n && Character.isDigit(s.charAt(i))) {

            num = num * 10 + (s.charAt(i) - '0');

    
            if (sign * num > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if (sign * num < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        return (int) (sign * num);
    }

    public static void main(String[] args) {

        String s = "   -042";

        System.out.println(myAtoi(s)); // -42
    }
}