import java.util.Arrays;
import java.util.Scanner;

class Arrange_Element_Even_Odd_Manner{
     public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
           
        int array_size;

        System.out.println("Enter Array Size : ");
        array_size=sc.nextInt();

        int array[]=new int[array_size];
        int Odd_Even[]=new int [array_size];

        for(int i=0; i<array_size; i++){
            System.out.println("Enter Array Element : ");
            array[i]=sc.nextInt();
        }

        int Odd_Index=0;
        int Event_index=1;

        for(int i=0; i<array_size; i++){
               if(array[i]%2==0){
                    Odd_Even[Event_index]=array[i];
                     Event_index+=2; 
               }else{
                Odd_Even[Odd_Index]=array[i];
                Odd_Index+=2;
               }
        }


        System.out.println("\n\n");
        System.out.println(Arrays.toString(Odd_Even));
        System.out.println("\n\n");


     }
}