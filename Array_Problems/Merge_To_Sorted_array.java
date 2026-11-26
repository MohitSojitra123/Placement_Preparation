// Merge two sorted arrays into one sorted array.

import java.util.Scanner;

public class Merge_To_Sorted_array {
    public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);

        int array_size_1,array_size_2;

        System.out.println("Enter Array 1 Size  : ");
        array_size_1=sc.nextInt();

        int array1[]=new int[array_size_1];

        for(int i=0; i<array_size_1; i++){
            System.out.println("Enter Array 1 Element : ");
            array1[i]=sc.nextInt();
        }

        System.out.println("\n------------------\n");
        
         System.out.println("Enter Array 2 Size : ");
         array_size_2=sc.nextInt();

         int array2[]=new int[array_size_2];

        for(int j=0; j<array_size_2; j++){
            System.out.println("Enter Array 2 Element : ");
            array2[j]=sc.nextInt();
        }
        
        System.out.println("\n------------------\n");
        System.out.println("array 1 :");
        System.out.println("\n------------------\n");
        
        for(int ele:array1){
            System.out.print(ele+" ");
        }
        System.out.println("\n------------------\n");
        System.out.println("");

        System.out.println("\n------------------\n");
        System.out.println("array 2 :");
        System.out.println("\n------------------\n");
        for(int ele:array2){
            System.out.print(ele+" ");
        }
        System.out.println("\n------------------\n");
        
        
        int i=0,j=0,k=0;
        int final_array[]=new int[array_size_1+array_size_2]; 
        
        while(i<array_size_1 && j<array_size_2){
            if(array1[i]<=array2[j]){
                final_array[k]=array1[i];
                i++;
                k++;
            }else{
                final_array[k]=array2[j];
                j++;
                k++;
            }
        }
        
        while(i<array_size_1){
            final_array[k]=array1[i];
            i++;
            k++; 
        }
        
        while(j<array_size_2){
            final_array[k]=array2[j];
            j++;
            k++;
        }
        
        System.out.println("\n------------------\n");
        for(int ele : final_array){
            System.out.print(ele+" ");
        }
        System.out.println("\n------------------\n");
        
    }
}
