import java.util.Scanner;

public class Subarray_Sum {
    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);

        System.out.println("Enter Array Size : ");
        int array_size=sc.nextInt();

        int array[]=new int[array_size];

        for(int i=0; i<array_size; i++){
            System.out.println("Enter Array Element : ");
            array[i]=sc.nextInt();
        }

        System.out.println("\n\n");
        for(int i=0; i<array_size; i++){
            System.out.println(array[i]+" ");
        }
        System.out.println("\n\n");

        int target_sum=0;

        System.out.println("Enter Target Value : ");
        target_sum=sc.nextInt();
        
        System.out.println("\n\n");

        for(int i=0; i<array_size; i++){
            for(int j=i; j<array_size; j++){
                int sum=0;
                for(int k=i; k<=j; k++){
                      sum+=array[k];
                }
                if(sum==target_sum){
                      for(int q=i; q<=j; q++){
                        System.out.println(array[q]);
                      }
                      System.out.println("\n\n");
                }
            }
        }


    }
}
