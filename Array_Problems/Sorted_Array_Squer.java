import java.util.Arrays;

class Sorted_Array_Squre{
    public static void main(String[] args) {
        
            int arr[]={-9,-6,-3,-1,3,6,8,10,12};

            int ans[]=new int[arr.length];

            System.out.println(Arrays.toString(arr));

            int left=0;
            int right=arr.length-1;
            int last_ptr=ans.length-1;

            while (left<right) {
                
                 int left_squre=arr[left]*arr[left];
                 int right_squre=arr[right]*arr[right];

                 if(left_squre>right_squre){
                    ans[last_ptr]=left_squre;
                    last_ptr--;
                    left++;
                 }else{
                     ans[last_ptr]=right_squre;
                     last_ptr--;
                     right--;
                 }
            }

            System.out.println(Arrays.toString(ans));
    }
}