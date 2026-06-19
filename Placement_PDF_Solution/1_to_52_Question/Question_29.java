// Given an integer n, return the least number of perfect square numbers that sum to n.  
// Input: n = 12 Output: 3 Explanation: 12 = 4 + 4 + 4. 
// Input: n = 13 Output: 2 Explanation: 13 = 4 + 9.

import java.util.*;

public class Question_29 {
    public static void main(String[] args) {


        int num=49;

        int i=(int)Math.sqrt(num);

        if(i*i==num){
            System.out.println("Number Is Perfect Squre : "+num);
        }else{
            System.out.println("Number Is Not Perfect Squre : "+num);
        }


    }
}