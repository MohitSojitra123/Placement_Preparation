import java.util.Scanner;

public class Extra_Program_3 {
    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);

         System.out.println("Enter Any Array Size => ");
         int array_size=sc.nextInt();

         int twod_array[][]=new int[array_size][array_size];

         for(int i=0; i<array_size; i++){
          for(int j=0; j<array_size; j++){
                  System.out.print("Enter Array Element => ");   
                 twod_array[i][j]=sc.nextInt(); 
          }
         }

         System.out.println("-----------------------------------");
              for(int i=0; i<array_size; i++){
          for(int j=0; j<array_size; j++){
               System.out.print(twod_array[i][j]+" ");   
          }
          System.out.println();
         }
         System.out.println("-----------------------------------");

         
         System.out.println("------------Sorting Row Wise------------");
         int temp=0;
         for(int i=0; i<array_size; i++){
           for(int j=0; j<array_size-1; j++){
             for(int k=j+1; k<array_size; k++){
               if(twod_array[i][j] > twod_array[i][k]){
                 temp=twod_array[i][j];
                 twod_array[i][j]=twod_array[i][k];
                 twod_array[i][k]=temp;
                }
              }
            }
          }

            for(int i=0; i<array_size; i++){
          for(int j=0; j<array_size; j++){
               System.out.print(twod_array[i][j]+" ");   
          }
          System.out.println();
         }


          System.out.println("---------------------------------------");
        
    }
}
