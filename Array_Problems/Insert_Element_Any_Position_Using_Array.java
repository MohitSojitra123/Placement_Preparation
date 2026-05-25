import java.util.Arrays;
import java.util.Scanner;

public class Insert_Element_Any_Position_Using_Array {
    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);

         System.out.println("Enter Array Size : ");
         int array_size=sc.nextInt();

         int array[]=new int[array_size+1];

         for(int i=0; i<array_size; i++){
                 System.out.println("Enter Array Element : ");
                 array[i]=sc.nextInt();
         }

         System.out.println("Enter Array New Element : ");
         int new_element=sc.nextInt();

         System.out.println("Enter New Element Position : ");
         int new_position=sc.nextInt();

         array_size++;

         for(int i=array_size-1; i>new_position; i--){
            array[i]=array[i-1];
         }

         array[new_position]=new_element;

     
         System.out.println("\n\n");
         System.out.println(Arrays.toString(array));
         System.out.println("\n\n");


    }
}
