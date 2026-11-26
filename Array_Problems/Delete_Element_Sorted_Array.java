// Delete element from sorted array.

import java.util.Scanner;

public class Delete_Element_Sorted_Array {
    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);

         int array_size;

        System.out.println("Enter Array Size : ");
        array_size=sc.nextInt();

        int array[]=new int[array_size];

        for(int i=0; i<array_size; i++){
            System.out.println("Enter Array Size : ");
            array[i]=sc.nextInt();
        }

        int temp=0;

         for(int i=0; i<array_size; i++){
            for(int j=i+1; j<array_size-1; j++){
                if(array[i]>array[j]){
                     temp=array[i];
                     array[i]=array[j];
                     array[j]=temp;
                }
            }
         }

        System.out.println("\n----------------------\n");
        for(int i=0; i<array_size; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println("\n----------------------\n");

        System.out.println("Enter Array Element : ");
        int delete_ele=sc.nextInt();

        int start=0;
        int end=array_size-1;
       int mid=0; 

        while(start<=end){
               mid=(start+end)/2;

               if(array[mid]==delete_ele){

                    for(int k=mid; k<array_size-1; k++){
                        array[k]=array[k+1];
                    } 
                   array_size--;

        System.out.println("\n----------------------\n");
        System.out.println("Delete Element : ");
        System.out.println("\n----------------------\n");
        for(int i=0; i<array_size; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println("\n----------------------\n");

                    break;
               }else if (array[mid] < delete_ele) {
                           start=mid+1;
               }else if(array[mid] > delete_ele){
                         end=mid-1;
               }
        }



    }
}
