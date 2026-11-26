// Given an array of N integers, and an integer K, find the number of pairs of elements in the 
// array whose sum is equal to K. 
// e.g.  
// Input: 
// N = 4, K = 6 
// arr[] = {1, 5, 7, 1} 
// Output: 2 
// Explanation:  
// arr[0] + arr[1] = 1 + 5 = 6  
// and arr[1] + arr[3] = 5 + 1 = 6.

import java.util.HashSet;

public class Problem_43 {
    public static void main(String[] args) {
     
        int array[]={1,5,7,1};
        int k=6;

        int count=0;

        HashSet<Integer> hs=new HashSet<>();

        for(int i=0; i<array.length; i++){


            int compliment=k-array[i];

            if(hs.contains(compliment)){
                count++;
            }

            hs.add(array[i]);
        }
        
        System.out.println("Count : "+count);
        
    }
}
