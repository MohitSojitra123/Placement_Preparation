import java.util.HashSet;
import java.util.Set;

public class Problem_3_1_Contains_Duplicate_1 {
    public static void main(String[] args) {
        
      int  nums[] = {1,2,3,1};
      boolean flag=false;

         Set<Integer> hs=new HashSet<>();

         for(int i=0; i<nums.length; i++){
              if(hs.contains(nums[i])){
                     flag=true;
                     break;
              }
              hs.add(nums[i]);
         }

         if(flag){
            System.out.println("Contains Duplicate Element : ");
         }else{
            System.out.println("Not Contains Duplicate Element : ");
         }

      

    }
}
