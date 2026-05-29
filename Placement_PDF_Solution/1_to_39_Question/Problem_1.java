// Given two sorted arrays of sizes m and n respectively, the task is to find the element 
// that would be at the k-th position in the final sorted array formed by merging these 
// two arrays. 
 
// Input: a[] = [2, 3, 6, 7, 9], b[] = [1, 4, 8, 10], k = 5 
// Output: 6 
// Explanation: The final sorted array is [1, 2, 3, 4, 6, 7, 8, 9, 10] 
// The 5th element is 6. 
 
// Input: a[] = [100, 112, 256, 349, 770],  
//             b[] = [72, 86, 113, 119, 265, 445, 892], k = 7 
// Output: 256 
// Explanation: The final sorted array is  
// [72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892]. 
// The 7th element is 256.

import java.util.Arrays;
import java.util.Scanner;

class Problem_1{
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);


        int arr1[]={2,3,6,7,9};
        int arr2[]={1,4,8,10};

        int sorted_array[]=new int[arr1.length+arr2.length];

        int i=0;
        int j=0;
        int current_index=0;

        while (i<arr1.length && j<arr2.length) {
              if(arr1[i]<arr2[j]){
                sorted_array[current_index]=arr1[i];   
                i++;
            }else{
                sorted_array[current_index]=arr2[j];       
                j++;
            }
            current_index++;
        }

        while (i<arr1.length) {
            sorted_array[current_index]=arr1[i];
            current_index++;
            i++; 
        }

        while (j<arr2.length) {
            sorted_array[current_index]=arr2[j];
            current_index++;
            j++; 
        }

        System.out.println(Arrays.toString(sorted_array));

        System.out.println("Enter Kth Position To Get Element : ");
        int kth=sc.nextInt();

        if(kth<sorted_array.length){
            System.out.println(sorted_array[kth]);
        }else{
            System.out.println("Not Valide Index : ");
        }

        
    }
}

