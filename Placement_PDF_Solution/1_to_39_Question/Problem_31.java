// 31 Write a program to generate very big (at least 11 digits) and calculate the total of all 
// those numbers. 
// In the program, User will input the first digit i.e. "D", input count i.e. "N" which needs 
// to generate automatically sequential bases from 1 to N, other remaining digits should 
// be 0 
// Input Validation 
// 0 ≤ D ≤ 9 
// 1 < N ≤ 1000  
 
// Explanation 
// Let's assume the inputs from the user for D is 5 and N is 50 
// ● So the generated numbers will be 50000000001, 50000000002, 50000000003, 
// 50000000004....  50000000050. 
// ● The calculated sum of above generated numbers is 2500000001275. 
// ● So output of this program should be 2500000001275. 
 
// Test Case-1 
// Input D: 5, N: 3 
// Output: 150000000006  
// Test Case - 2 
// Input: D: 3 
// Output N: 10 
// Output: 300000000055  
// Test Case - 3 
// Input: D: 9 N: 100 
// Output: 9000000005050  
// Note: All data types are allowed except float, double and long in this program.

import java.math.BigInteger;
import java.util.Scanner;

public class Problem_31 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter D: ");
        int D = sc.nextInt();

        System.out.print("Enter N: ");
        int N = sc.nextInt();

        // Input Validation
        if (D < 0 || D > 9) {
            System.out.println("Invalid D");
            return;
        }

        if (N <= 1 || N > 1000) {
            System.out.println("Invalid N");
            return;
        }

        BigInteger base =
                BigInteger.valueOf(D)
                          .multiply(BigInteger.TEN.pow(10));

        BigInteger sum =
                base.multiply(BigInteger.valueOf(N));

        BigInteger seriesSum =
                BigInteger.valueOf((long)N)
                          .multiply(BigInteger.valueOf(N + 1))
                          .divide(BigInteger.valueOf(2));

        sum = sum.add(seriesSum);

        System.out.println("Total Sum = " + sum);
    }
}