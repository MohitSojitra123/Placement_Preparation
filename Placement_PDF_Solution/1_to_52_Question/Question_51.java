// Given an array of coins[] of size n and a target value sum, where coins[i] represent the coins of different 
// denominations. You have an infinite supply of each of the coins. The task is to find the minimum 
// number of coins required to make the given value sum. If it is not possible to form the sum using the 
// given coins, return -1. 
// Input: coins[] = [25, 10, 5], sum = 30 
// Output: 2 
// Explanation : Minimum 2 coins needed, 25 and 5   
// Input: coins[] = [9, 6, 5, 1], sum = 19 
// Output: 3 
// Explanation: 19 = 9 + 9 + 1 

import java.util.Arrays;

public class Question_51 {

    public static void main(String[] args) {
        
        //    int Coins[]={25,10,5};
           int Coins[]={9,6,5,1};

           int sum=83,count=0;

           Arrays.sort(Coins);

           int i=Coins.length-1;



           while (sum!=0 ||  i>=0) {
            
               while (Coins[i]<=sum) {
                  sum-=Coins[i];
                  count++;
               }

               i--;
           }

           System.out.println("Count : "+count);

    }
    
}
