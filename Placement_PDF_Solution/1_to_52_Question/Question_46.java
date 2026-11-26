// Given  a  non-negative  integer  x,  compute  and  return  the  square  root  of  x.  Since  the  return  type  is  an 
// integer, the decimal digits are truncated, and only the integer part of the result is returned.  Note: You 
// are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5. 

import java.util.Scanner;

public class Question_46 {

    public static int mySqrt(int x) {

        if (x == 0 || x == 1) {
            return x;
        }

        int left = 1;
        int right = x;
        int ans = 0;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Use long to avoid integer overflow
            long square = (long) mid * mid;

            if (square == x) {
                return mid;
            } 
            else if (square < x) {
                ans = mid;       // Store possible answer
                left = mid + 1;  // Search right half
            } 
            else {
                right = mid - 1; // Search left half
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int x = sc.nextInt();

        System.out.println("Square Root = " + mySqrt(x));

        sc.close();
    }
}