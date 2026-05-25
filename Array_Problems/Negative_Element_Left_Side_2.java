// Move all negative elements to beginning.

import java.util.Scanner;

public class Negative_Element_Left_Side_2 {
    public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);

          System.out.println("Enter Array Size  : ");
          int array_size=sc.nextInt();

          int array[]=new int [array_size];
          int final_array[]=new int [array_size];


          for(int i=0; i<array_size; i++){
            System.out.println("Enter Array Element : ");
            array[i]=sc.nextInt();
          }

          int negative_index=0;
          int positive_index=0;

          for(int i=0; i<array_size; i++){
                if(array[i]<0){
                    final_array[negative_index]=array[i];
                    negative_index++;
                }
          }

          positive_index=negative_index;

          for(int i=0; i<array_size; i++){
              if(array[i]>=0){
                 final_array[positive_index]=array[i];
                 positive_index++;
              }
          }

          System.out.println("\n-------------------------\n");
          for(int i=0; i<array_size; i++){
            System.out.print(final_array[i]+" ");
          }
          System.out.println("\n-------------------------\n");
        


    }
}
