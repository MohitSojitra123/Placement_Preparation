
import java.util.Scanner;

public class Pair_Sum {
    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);

         System.out.println("Enter Array SIze : ");
         int array_size=sc.nextInt();

         int array[]=new int[array_size];

        for(int i=0; i<array_size; i++){
            System.out.println("Enter Array Element  : ");
            array[i]=sc.nextInt();
        }

        System.out.println("\n--------------------------\n");
        for(int i=0; i<array_size; i++){
            System.out.print(array[i]+" ");
        }  
        System.out.println("\n--------------------------\n");

        System.out.println("Enter Sum Value : ");
        int sum=sc.nextInt();

        for(int i=0; i<array_size; i++){
            for(int j=i+1; j<array_size; j++){
                if((array[i] + array[j]) == sum){
                    System.out.println("Two Element Is : ["+ array[i] +", "+array[j] +"]");
                }
            }
        }

          

    }
}
