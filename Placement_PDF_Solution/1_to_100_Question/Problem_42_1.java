// WAP to implement a sliding window problem. You are given an array of integers nums, 
// there is a sliding window of size k which is moving from the very left of the array to the 
// very right. You can only see the k numbers in the window. Each time the sliding window 
// moves right by one position. 
// Input: nums = [1,3, -1, -3,5,3,6,7], k = 3 
// Output: [3,3,5,5,6,7]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Problem_42_1 {
    public static void main(String[] args) {
        
        int nums[]={1,3,-1,-3,5,3,6,7};

        int k=3;

       ArrayList<Integer> Arr=new ArrayList<>();

       
       for(int i=0; i<nums.length; i++){
           ArrayList<Integer> Temp=new ArrayList<>();

            if((i+k)<=nums.length){
                for(int j=i; j<i+k; j++){
                       Temp.add(nums[j]);
                }

              int ans =  Collections.max(Temp);

              Arr.add(ans);
            }
        }

        System.out.println(Arr);

    }
}
