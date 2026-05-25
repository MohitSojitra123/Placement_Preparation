import java.util.Scanner;

public class Remove_Duplicate_Number {
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

          for(int i=0; i<array_size-1; i++){
            for(int j=0; j<array_size-i-1; j++){
                if(array[j]>array[j+1]){
                    int Temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=Temp;
                }
            }
          }

          System.out.println("\n----------------\n");
          
          for(int i=0; i<array_size; i++){
              System.out.print(array[i]+" ");
            }
            
            System.out.println("\n----------------\n");


            for(int i=0; i<array_size; i++){
                for(int j=i+1; j<array_size; j++){
                    if(array[i]==array[j]){
                        for(int k=j; k<array_size-1; k++){
                            array[k]=array[k+1];
                        }
                        array_size--;
                        j--;
                    }
                }
            }


        System.out.println("\n----------------\n");
          
          for(int i=0; i<array_size; i++){
              System.out.print(array[i]+" ");
            }
            
            System.out.println("\n----------------\n");


    }
}
