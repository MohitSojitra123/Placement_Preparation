// 16 Given an array arr[] of n integers and a target value, the task is to find whether there 
// is a pair of elements in the array whose sum is equal to target.  
// Input: arr[] = [0, -1, 2, -3, 1], target = -2 
// Output: true 
// Explanation: There is a pair (1, -3) with the sum equal to the given target, 1 + (-3) = -
// 2.  
// Input: arr[] = [1, -2, 1, 0, 5], target = 0 
// Output: false 
// Explanation: There is no pair with sum equals to given target. 

import java.util.HashSet;

public class Problem_16_2 {
    public static void main(String[] args) {
     
        int array[]={0, -1, 2, -3, 1};

         int target=-2;

         HashSet<Integer> s=new HashSet<>();

         for(int i=0; i<array.length; i++){

            int complement=target-array[i];

              if(s.contains(complement)){
                 System.out.println("["+complement+","+array[i]+"]");  
              }else{
                  s.add(array[i]);
              }

         }


        
    }
}
