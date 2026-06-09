// 35 Write  a    program  to  reverse  the  elements  of  an  array  without  using  a  temporary 
// array.  
// Input: Enter the number of elements in the array: 5 
//             1 2 3 4 5 
// Output: Reversed array: 5 4 3 2 1

import java.util.Arrays;

public class Problem_35 {
    public static void main(String[] args) {
        
          int array[]={1,2,3,4,5};

          System.out.println(Arrays.toString(array));
          
          int left=0;
          int right=array.length-1;
          
          while (left<right) {
              int temp=array[left];
              array[left]=array[right];
              array[right]=temp;
              left++;
              right--;
            }
            
            System.out.println(Arrays.toString(array));

    }
}
