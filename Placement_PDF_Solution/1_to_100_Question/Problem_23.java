import java.util.Arrays;
import java.util.Scanner;

public class Problem_23 {
    public static void main(String[] args) {
        
         Scanner sc=new Scanner(System.in);

         System.out.println("Enter Array Size : ");
         int array_size=sc.nextInt();

         int array[]=new int[array_size+1];

         for(int i=0; i<array_size; i++){
            System.out.println("Enter Array  Element : ");
            array[i]=sc.nextInt();
         }

         for(int i=0; i<array_size; i++){
            System.out.print(array[i]+" ");
         }

         System.out.println();

         System.out.println("Enter New Element : ");
         int new_ele=sc.nextInt();

         System.out.println("Enter Index Number : ");
         int index_num=sc.nextInt();

         if(index_num>array_size || index_num<0){
            System.out.println("Index Invalide : ");
            return;
         }

         array_size++;
         
         for(int i=array_size-1; i>index_num; i--){
             array[i]=array[i-1];
            }

            array[index_num]=new_ele;

         System.out.println(Arrays.toString(array));


    }
}
