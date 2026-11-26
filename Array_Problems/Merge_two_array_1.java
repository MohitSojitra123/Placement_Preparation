// Merge two arrays into a third array.

import java.util.Scanner;

public class Merge_two_array_1 {
    public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);

          int array_size1,array_size2;

          System.out.println("Enter Array 1 Size : ");
          array_size1=sc.nextInt();
          
          System.err.println("\n----------------------\n");

            System.out.println("Enter Array 2 Size : ");
          array_size2=sc.nextInt();

          System.err.println("\n----------------------\n");

          int array1[]=new int[array_size1];
          int array2[]=new int[array_size2];

          for(int i=0; i<array_size1; i++){
            System.out.println("Enter Array 1 Element : ");
            array1[i]=sc.nextInt();
          }

          System.err.println("\n----------------------\n");

            for(int i=0; i<array_size2; i++){
            System.out.println("Enter Array 2 Element : ");
            array2[i]=sc.nextInt();
          }


          System.err.println("\n----------------------\n");
          for(int i=0; i<array_size1; i++){
            System.out.println(array1[i]);
          }
          System.err.println("\n----------------------\n");
        for(int i=0; i<array_size2; i++){
            System.out.println(array2[i]);
          }
          System.err.println("\n----------------------\n");
          
          
          int merge_array[]=new int[array_size1+array_size2];
          
          for(int i=0; i<array_size1; i++){
              merge_array[i]=array1[i];
            }
            
            int count=0;
            
            for(int j=array_size1; j<(array_size1+array_size2); j++){
                merge_array[j]=array2[count];
                count++;
            }
            
            for(int i=0; i<(array_size1+array_size2); i++){
                System.out.println(merge_array[i]+" ");
            }

            System.err.println("\n----------------------\n");

    }
}
