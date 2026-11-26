// Sort Rows of Matrix

import java.util.Scanner;

public class Sort_2d_Matrix {
    public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);

          System.out.println("Enter Array Size : ");
          int array_size=sc.nextInt();

          int array[][]=new int[array_size][array_size];

          for(int i=0; i<array_size; i++){
            for(int j=0; j<array_size; j++){
                System.out.println("Enter Array Element : ");
                array[i][j]=sc.nextInt();
            }
          }

          System.out.println("\n---------------------\n");
          for(int i=0; i<array_size; i++){
            for(int j=0; j<array_size; j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
          }
          System.out.println("\n---------------------\n");


          for(int i=0; i<array_size; i++){
            for(int j=0; j<array_size; j++){
                for(int k=j+1; k<array_size; k++){
                    if(array[i][j]>array[i][k]){
                        int temp=array[i][j];
                        array[i][j]=array[i][k];
                        array[i][k]=temp;
                    }
                }
            }
          }

            System.out.println("After Sort : ");
             System.out.println("\n---------------------\n");
          for(int i=0; i<array_size; i++){
            for(int j=0; j<array_size; j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
          }
          System.out.println("\n---------------------\n");


        }
}
