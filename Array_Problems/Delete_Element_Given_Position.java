// Delete an element from a given position.

import java.util.Scanner;

public class Delete_Element_Given_Position {
      public static void main(String[] args) {
           Scanner sc=new Scanner(System.in);

          int array_size;

          System.out.println("Enter Array Size : ");
          array_size=sc.nextInt();
          
          int array[]=new int[array_size];

          for(int i=0; i<array_size; i++){
               System.out.println("Enter Array Element : ");
               array[i]=sc.nextInt();
          }

          System.out.println("\n------------------------\n");
          for(int i=0; i<array_size; i++){
            System.out.println(array[i]);
          }
          System.out.println("\n------------------------\n");

          int index_num=0;

          System.out.println("Enter Element Index Number To  Delete Element  : ");
          index_num=sc.nextInt();

          for(int i=0; i<array_size; i++){
            if(i==index_num){
                  for(int j=i; j<array_size-1; j++){
                    array[j]=array[j+1];
                  }
                  array_size--;
            }
          }

        System.out.println("\n------------------------\n");
          for(int i=0; i<array_size; i++){
            System.out.println(array[i]);
          }
        System.out.println("\n------------------------\n");

      } 
}
