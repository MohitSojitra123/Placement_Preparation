// Given a non-negative integer x, compute and return the square root of x. 
// Since the return type is an integer, the decimal digits are truncated, and only the integer part 
// of the result is returned. 
// Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 
// 0.5) or x ** 0.5.

public class Problem_52 {

    public static void main(String[] args) {

        int x = 20;

        int ans = 0;

        for (int i = 1; i <= x; i++) {

            if ((long) i * i <= x) {
                ans = i;
            } else {
                break;
            }
        }

        System.out.println(ans);
    }
}