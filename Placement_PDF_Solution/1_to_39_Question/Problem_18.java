// 18 Write a program to merge two arrays into one, but if any element is repeated in the 
// arrays, it should appear only once, and the duplicates should be replaced with zeros.  
// Input: Enter the size of first array: 4 
//             Enter the elements of first array: 7 2 5 9 
//             Enter the size of second array: 5 
//             Enter the elements of second array: 5 9 3 7 8 
// Output: Merged array: 7  2  5  9  0  0  3  0  8

import java.util.Arrays;

public class Problem_18 {
    public static void main(String[] args) {
        
        int array1[]={7,2,5,9,6};
        int array2[]={5,9,3,7,8};

        int new_array[]=new int[array1.length+array2.length];

         int other_i=0;

        for(int i=0; i<new_array.length; i++){
              if(i<array1.length){
                 new_array[i]=array1[i];
              }else{
                  new_array[i]=array2[other_i++];
              }
        }

        System.out.println(Arrays.toString(new_array));
        
        for(int i=0; i<new_array.length; i++){
            if(new_array[i]==0){
                continue;
            }else{
                for(int j=i+1; j<new_array.length; j++){
                    if(new_array[i]==new_array[j]){
                        new_array[j]=0;
                    }
                }
            }
        }
        
        System.out.println(Arrays.toString(new_array));
       

    }
}
