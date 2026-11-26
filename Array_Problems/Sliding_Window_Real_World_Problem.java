// Input: nums = [1,12,-5,-6,50,3], k = 4
// Output: 12.75000
// Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75


class Solution {
    public double findMaxAverage(int[] nums, int k) {

          int sum=0;

        for(int i=0; i<k; i++){
            sum+=nums[i];
        }

        int max_sum=sum;

        for(int j=k; j<nums.length; j++){

            sum=sum+(nums[j]-nums[j-k]);

            if(sum>max_sum){
                max_sum=sum;
            }
        }

        return (double)max_sum/k;
    }
}


public class Sliding_Window_Real_World_Problem {
  public static void main(String[] args) {
    
  }    
}
