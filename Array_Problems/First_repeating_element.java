// Find first repeating element in an array.

import java.util.Scanner;

public class First_repeating_element {
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

        System.out.println("\n--------------------------\n");
        for(int ele : array){
            System.out.print(ele+" ");
        }
        System.out.println("\n--------------------------\n");

        boolean found=false;

        for(int i=0; i<array_size; i++){
              for(int j=i+1; j<array_size; j++){
                if(array[i]==array[j]){
                       System.out.println("First Repeating Element Is : "+array[i]);
                       found=true;
                       break;
                }
              }
              if(found){
                break;
              }
        }

        System.out.println("End..............");


    }
}
