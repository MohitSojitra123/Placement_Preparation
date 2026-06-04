// 5 Find  the  difference  between  the  second  largest  element  and  the  second  smallest 
// element of an array. 
 
// Input :  Enter the size of array: 7 
//               Enter 7 elements: 5 1 9 7 1 5 3 
// Output: Difference: 4

import java.util.Scanner;

public class Problem_5 {
    public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);

           int array_size;

           System.out.println("Enter Array Size : ");
           array_size=sc.nextInt();

           int arr[]=new int[array_size];

           for(int i=0; i<array_size; i++){
            System.out.println("Enter Array Element : ");
            arr[i]=sc.nextInt();
           }

           int first_small=Integer.MAX_VALUE;
           int second_small=Integer.MAX_VALUE;
           int first_big=Integer.MIN_VALUE;
           int second_big=Integer.MIN_VALUE;

           for(int i=0; i<array_size; i++){
               if(arr[i]>first_big){
                   second_big=first_big;
                   first_big=arr[i];
               }else if(arr[i]>second_big && arr[i] != first_big){
                  second_big=arr[i];
               }

               if(arr[i]<first_small){
                second_small=first_small;
                first_small=arr[i];
               }else if(arr[i]<second_small && arr[i]!=first_small){
                    second_small=arr[i];  
               }
            }

            System.out.println("Difference : "+(second_big-second_small));

    }
}
