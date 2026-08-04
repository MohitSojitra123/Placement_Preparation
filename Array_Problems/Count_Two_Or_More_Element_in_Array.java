// Input: nums = [0,0,1,1,1,1,2,3,3]
// Output: 7, nums = [0,0,1,1,2,3,3,_,_]
// Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
// It does not matter what you leave beyond the returned k (hence they are underscores).

class Count_Two_Or_More_Element_in_Array {
    public int removeDuplicates(int[] nums) {
        
        int current_count=1;
        int k=0;

       for(int i=0; i<nums.length; i++){
        
          int temp_i=0;
          current_count=1;

        for(int j=i+1; j<nums.length; j++){
            if(nums[i]==nums[j]){
                current_count++;
                temp_i++;
            }else{
              break;
            }
        }

        if(current_count>=2){
            k+=2;
            i+=temp_i;
        }else{
          k+=current_count;
          i+=temp_i;
        }

       }
       return k;
    }

    public static void main(String[] args) {
        

        Count_Two_Or_More_Element_in_Array c=new Count_Two_Or_More_Element_in_Array();

        int array[]={0,0,1,1,1,1,2,3,3,3,3,4,4,5};

        System.out.println(c.removeDuplicates(array));


    }
}