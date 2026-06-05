// 19 Given an array of coins[] of size n and a target value sum, where coins[i] represent 
// the coins of different denominations. You have an infinite supply of each of the coins. 
// The task is to find the minimum number of coins required to make the given value 
// sum. If it is not possible to form the sum using the given coins, return -1.  
// Input: coins[] = [25, 10, 5], sum = 30 
// Output: 2 
// Explanation : Minimum 2 coins needed, 25 and 5    
// Input: coins[] = [9, 6, 5, 1], sum = 19 
// Output: 3 
// Explanation: 19 = 9 + 9 + 1  
// Input: coins[] = [4, 6, 2], sum = 5 
// Output: -1 
// Explanation: Not possible to make the given sum.

import java.util.Arrays;

public class Problem19 {

    static int minCoins(int[] coins, int sum) {

        Arrays.sort(coins);

        int count = 0;

        for (int i = coins.length - 1; i >= 0; i--) {

            while (sum >= coins[i]) {
                sum -= coins[i];
                count++;
            }
        }

        return (sum == 0) ? count : -1;
    }

    public static void main(String[] args) {

        int coins[] = {25, 10, 5};
        int sum = 30;

        System.out.println(minCoins(coins, sum));
    }
}