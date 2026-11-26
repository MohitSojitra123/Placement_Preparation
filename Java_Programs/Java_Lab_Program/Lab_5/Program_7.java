// There is an integer array nums sorted in ascending order (with distinct values).
// Prior to being passed to your function, nums is possibly rotated at an unknown pivot
// index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ...,
// nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7]
// might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
// Given the array nums after the possible rotation and an integer target, return the
// index of target if it is in nums, or -1 if it is not in nums.[C]
// Example 1:
// Input: nums = [4,5,6,7,0,1,2], target = 0
// Output: 4
// Example 2:
// Input: nums = [4,5,6,7,0,1,2], target = 3
// Output: -1

import java.util.Scanner;

public class Program_7 {
    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);

        int array_size;

        System.out.println("Enter Array Size : ");
        array_size=sc.nextInt();

        int array[]=new int[array_size];

        for(int i=0; i<array.length; i++){
            System.out.println("Enter Array Element :  "+ i);
            array[i]=sc.nextInt();
        }

        System.out.println("-----------------------------");
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
        System.out.println("-----------------------------");

        System.out.println("Enter Target Number : ");
        int user_targer=sc.nextInt();

        int target_element_index=-1;

        for(int i=0; i<array_size; i++){
              if(array[i] == user_targer){
                target_element_index=i;
              }
        }

        if(target_element_index == -1){
            System.out.println("Element Not Parsent : "+target_element_index);
        }else{
            System.out.println("Element Index Is : "+target_element_index);
        }

    }
}
