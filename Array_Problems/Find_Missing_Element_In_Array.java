import java.util.Scanner;

public class Find_Missing_Element_In_Array {
    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
         
         int array[]={1,2,3,4,6,7};

         int n=array.length+1;


         int Total_Sum=n*(n+1)/2;
         int Array_Sum=0;

         for(int i=0; i<array.length; i++){
              Array_Sum+=array[i];
         }

         System.out.println("\n-----------------\n");
         System.out.println("Missing Element Is : "+ (Total_Sum-Array_Sum));
         System.out.println("\n-----------------\n");


    }
}
