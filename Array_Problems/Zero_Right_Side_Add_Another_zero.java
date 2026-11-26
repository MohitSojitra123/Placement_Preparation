// Input: arr = [1,0,2,3,0,4,5,0]
// Output: [1,0,0,2,3,0,0,4]

// Question --> 1089

import java.util.Arrays;

public class Zero_Right_Side_Add_Another_zero{
    public static void main(String[] args) {
        
          int arr[]={1,0,2,3,0,4,5,0};

          System.out.println(Arrays.toString(arr));

          for(int i=0; i<arr.length; i++){
            
              if(arr[i]==0){
                for(int j=arr.length-1; j>i; j--){
                     arr[j]=arr[j-1];
                }

                arr[i+1]=0;
                i++;
              }

          }

          System.out.println(Arrays.toString(arr));

    }
}