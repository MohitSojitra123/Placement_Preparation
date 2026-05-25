// Split Array

import java.util.Scanner;

public class Extra_Program_4 {
     public static void main(String[] args) {
           Scanner sc=new Scanner(System.in);


          System.out.println("Enter Array Size => ");
          int array_size=sc.nextInt();

          int array[]=new int[array_size];
          int array2[]=new int[array_size];
          
          for(int i=0; i<array_size; i++){
             System.out.println("Enter Array Element => "+(i+1));
             array[i]=sc.nextInt();
          }


        System.out.println("Enter Index Number To Split Array => ");
        int split=sc.nextInt();

        int start=0;

        for(int i=split; i<array_size; i++){
              array2[start]=array[i];
              start++;
        }

        start=array_size-split;

        for(int i=0; i<split; i++){
               array2[start]=array[i];
               start++;
        }

        System.out.println("-------------------------------");
          for(int i=0; i<array_size; i++){
            System.out.print(array2[i]+" ");
          }
          System.out.println();
          System.out.println("-------------------------------");

           System.out.println("Enter Target Value => ");
           int user_target=sc.nextInt();
           
             int temp=-1;

             for(int i=0; i<array_size; i++){
                if(array2[i] == user_target){
                       temp=i;
                       break;
                }
             }

              if(temp == -1){
                   System.out.println("Target Element Not Find  -1");
              }else{
                System.out.println("Target Element Index Number Is  "+temp);
              }

        }
}

// 10 20 30 40 50
// 0   1     2    3    4