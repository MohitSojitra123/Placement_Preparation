// Remove duplicate elements from an array.

import java.util.Scanner;

public class Delete_duplicate_ele {
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

    System.out.println("\n---------------------------\n");
    for(int i=0; i<array_size; i++){
        System.out.println(array[i]+" ");
    }
    System.out.println("\n---------------------------\n");

    for(int i=0; i<array_size; i++){
        for(int j=i+1; j<array_size; j++){
            if(array[i]==array[j]){
                   for(int k=j; k<array_size-1; k++){
                      array[k]=array[k+1];
                   }
                   array_size--;
            }
        }
    }

    System.out.println("\n---------------------------\n");
    for(int i=0; i<array_size; i++){
        System.out.println(array[i]+" ");
    }
    System.out.println("\n---------------------------\n");




    }
}
