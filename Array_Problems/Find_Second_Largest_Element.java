// Find the second largest element in an array.

import java.util.Scanner;

public class Find_Second_Largest_Element {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

         int array_size;

        System.out.println("Enter Array Size : ");
        array_size=sc.nextInt();
        
        int array[]=new int[array_size];

        int big_1=Integer.MIN_VALUE;
        int big_2=Integer.MIN_VALUE;

        for(int i=0; i<array_size; i++){
            System.out.println("Enter Array Element  : ");
            array[i]=sc.nextInt();

            if(array[i] > big_1){
                big_2=big_1;
                big_1=array[i];
            }else if(array[i] > big_2 && array[i] != big_1){
                  big_2=array[i];
            }
        }

        System.out.println("Big 1 : "+big_1);
        System.out.println("Big 2 : "+big_2);

    }
}

