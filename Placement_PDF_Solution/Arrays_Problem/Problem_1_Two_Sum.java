import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Problem_1_Two_Sum{
    public static void main(String[] args) {
        
         int nums[] = {2,7,11,15};
         int target = 9;
         
      
         HashMap<Integer,Integer> HM=new HashMap<>();

         for(int i=0; i<nums.length; i++){
               
            int current_value=target-nums[i];

            if(HM.containsKey(current_value)){
                  System.out.println("Index Number : [ "+HM.get(current_value)+" , "+i+" ]");
                  break;
            }else{
                  HM.put(nums[i], i);
            }
         }

    }
}