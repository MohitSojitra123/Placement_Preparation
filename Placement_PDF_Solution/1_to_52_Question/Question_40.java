// Given 2 sorted arrays a[] and b[], each of size n, the task is to find the median of the array obtained 
// after merging a[] and b[]. 
// Input: a[] = [1, 12, 15, 26, 38], b[] = [2, 13, 17, 30, 45] 
// Output: 16 
// Explanation: The middle two elements are 15 and 17,  
// so median = (15 + 17)/2 = 16 

import java.util.Arrays;

public class Question_40 {
    public static void main(String[] args) {
        
          int a[]={1, 12, 15, 26, 38};
          int b[]={2, 13, 17, 30, 45};

          int final_array[]=new int[a.length+b.length];

          int i=0,j=0,current_index=0;

          while (i<a.length && j<b.length) {
               if(a[i]<=b[j]){
                   final_array[current_index++]=a[i++];
               }else{
                final_array[current_index++]=b[j++];
               }
          }

          while (i<a.length) {
              final_array[current_index]=a[i++];
          }

          while (j<b.length) {
               final_array[current_index]=b[j++];
          }

          System.out.println(Arrays.toString(final_array));

          if(final_array.length%2==0){
              System.out.println((final_array[final_array.length/2]+final_array[(final_array.length/2)-1])/2);
          }else{
            System.out.println(final_array[final_array.length/2]);
          }


    }
}
