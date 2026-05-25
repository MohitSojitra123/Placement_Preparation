// Find second largest and second smallest in single scan.

import java.util.Scanner;

public class Second_Largest_and_Smallest_Element {
    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);

        int array_size;

        System.out.println("Enter Array Size : ");
        array_size=sc.nextInt();

        int array[]=new int[array_size];

        for(int i=0; i<array_size; i++){
              System.out.println("Enter Array Element  : ");
              array[i]=sc.nextInt();
        }

        System.out.println("\n----------------------\n");
        for(int i=0; i<array_size; i++){
            System.out.println(array[i]+" ");
        }
        System.out.println("\n----------------------\n");

        int big_1=Integer.MIN_VALUE;
        int big_2=Integer.MIN_VALUE;

        int small_1=Integer.MAX_VALUE;
        int small_2=Integer.MAX_VALUE;

        for(int i=0; i<array_size; i++){
              if(array[i]>big_1){
                  big_2=big_1;
                  big_1=array[i];
              } else if (array[i] > big_2 && array[i] != big_1) {
                  big_2=array[i];
              }

            if(array[i] < small_1){
                small_2=small_1;
                small_1=array[i];
            }else if(array[i]<small_2 && array[i] != small_1){
                small_2=array[i];
            }
        }

    System.out.println("Big 1 : "+big_1);
    System.out.println("Big 2 : "+big_2);
    System.out.println("Small 1 : "+small_1);
    System.out.println("Small 2 : "+small_2);
    
    }
}
