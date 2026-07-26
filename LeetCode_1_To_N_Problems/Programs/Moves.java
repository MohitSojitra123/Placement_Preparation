class move_Zeroes_Question_283 {
    public void main(int[] nums) {
        
        int current_index=0;

        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0){
                int temp=nums[i];
                nums[i]=0;
                nums[current_index]=temp;
                current_index++;
            }
        }

    }
}