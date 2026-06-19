// WAP to enter an element at specific position into array. (Do not take a new array) 

import java.util.Arrays;
import java.util.Scanner;

public class Question_10 {
    public static void main(String[] args) {
       
          Scanner sc=new Scanner(System.in);
         
          System.out.println("Enter Array Size : ");
          int array_size=sc.nextInt();

          int array[]=new int[array_size+1];
        
          for(int i=0; i<array_size; i++){
            System.out.println("Enter Array Element : ");
            array[i]=sc.nextInt();
          }

        for(int i=0; i<array_size; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();

          System.out.println("Enter Specific Index To Insert Element : ");
          int index=sc.nextInt();

          System.out.println("Enter New Element : ");
          int new_ele=sc.nextInt();

          if(index>array_size){
            System.out.println(" Index Invalid : ");
            return;
          }

          array_size++;

          for(int i=array_size-1; i>index; i--){
            array[i]=array[i-1];
          }

          array[index]=new_ele;

          System.out.println(Arrays.toString(array));

    }
}
