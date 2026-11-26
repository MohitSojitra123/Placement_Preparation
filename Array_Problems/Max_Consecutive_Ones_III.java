// Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
// Output: 6
// Explanation: [1,1,1,0,0,1,1,1,1,1,1]
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

// Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
// Output: 10
// Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

public class Max_Consecutive_Ones_III{
   public static void main(String[] args){
      
      //   int nums[] = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
      //    int k=2;

      int nums[] = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
      int  k = 3;

        int max=0;

        for(int i=0; i<nums.length; i++){

            int count_zero=0;
            int temp_max=0;

            for(int j=i; j<nums.length; j++){
                   if(nums[j]==0){
                          count_zero++;
                   }

                   if(count_zero>k){
                     break;
                   }

                   temp_max++;
            }
            max=Math.max(temp_max, max);
        }

        System.out.println("Max : "+max);

   }
}