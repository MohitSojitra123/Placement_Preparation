// 13 Given two sorted arrays, the task is to merge them in a sorted manner.  
// Input: arr1[] = { 1, 3, 4, 5}, arr2[] = {2, 4, 6, 8}  
// Output: arr3[] = {1, 2, 3, 4, 4, 5, 6, 8}  
// Input: arr1[] = { 5, 8, 9}, arr2[] = {4, 7, 8}  
// Output: arr3[] = {4, 5, 7, 8, 8, 9} 

import java.util.Arrays;

public class Problem_13 {
    public static void main(String[] args) {
        

        int array1[]={ 1, 3, 4, 5};
        int array2[]={2, 4, 6, 8};

        int array_1_current_index=0;
        int array_2_current_index=0;

        int final_array_current_index=0;

        int final_sorted_array[]=new int[array1.length+array2.length];


        while (array_1_current_index<array1.length && array_2_current_index<array2.length) {
            
              if(array1[array_1_current_index] <= array2[array_2_current_index]){
                final_sorted_array[final_array_current_index]=array1[array_1_current_index];
                array_1_current_index++;
              }else{
                  final_sorted_array[final_array_current_index]=array2[array_2_current_index];
                  array_2_current_index++;
              }
              final_array_current_index++;
        }
    
        while (array_1_current_index<array1.length) {
              final_sorted_array[final_array_current_index]=array1[array_1_current_index];
              array_1_current_index++;
              final_array_current_index++; 
        }

        while (array_2_current_index<array2.length) {
             final_sorted_array[final_array_current_index]=array2[array_2_current_index];
             array_2_current_index++;
             final_array_current_index++;
        }

        System.out.println(Arrays.toString(final_sorted_array));


    }
}
