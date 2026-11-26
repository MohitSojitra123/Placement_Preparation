// Rotate array elements to the left.

import java.util.Scanner;

public class Rotate_left {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);

         int array_size;

         System.out.println("Enter Array Size : ");
         array_size=sc.nextInt();

         int array[]=new int[array_size];
         int rotate_array[]=new int[array_size];

         for(int i=0; i<array_size; i++){
              System.out.println("Enter Array Element : ");
              array[i]=sc.nextInt();
        }

        System.out.println("\n----------------------------\n");
        for(int i=0; i<array_size; i++){
            System.out.println(array[i]+" ");
        }
        System.out.println("\n----------------------------\n");

        int rotate_index;

        System.out.println("Enter Index Number To Rotate Array : ");
        rotate_index=sc.nextInt();

        int count=0;

        for(int i=rotate_index; i<array_size; i++){
              rotate_array[count]=array[i];
              count++;
        }

        for(int j=0; j<rotate_index; j++){
            rotate_array[count]=array[j];
            count++;
        }

        System.out.println("\n----------------------------\n");
        System.err.println("Rotate Array : ");
        System.out.println("\n----------------------------\n");
        for(int i=0; i<array_size; i++){
            System.out.println(rotate_array[i]+" ");
        }
        System.out.println("\n----------------------------\n");
        
    }
}
