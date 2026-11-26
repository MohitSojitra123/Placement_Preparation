import java.util.Scanner;

public class Find_Missing_Element_in_Array {
    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);

        int array_size;

        System.out.println("Enter Array Size : ");
        array_size=sc.nextInt();

        int array[]=new int[array_size];
        int array_sum=0;

        for(int i=0; i<array_size; i++){
            System.out.println("Enter Array Element : ");
            array[i]=sc.nextInt(); 
            array_sum+=array[i];
        }

        int n=array_size+1;

        int Real_Array_Sum=n*(n+1)/2;

        System.out.println("Missing Element Is : "+(Real_Array_Sum-array_sum));

    }
}
