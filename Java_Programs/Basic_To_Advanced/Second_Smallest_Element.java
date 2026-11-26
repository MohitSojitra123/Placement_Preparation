import java.util.Scanner;

public class Second_Smallest_Element {
    public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);

          System.out.println("Enter Array Size  : ");
          int array_size=sc.nextInt();

          int array[]=new int[array_size];

          for(int i=0; i<array_size; i++){
            System.out.println("Enter Array Element : ");
            array[i]=sc.nextInt();
          }

          int small_1=Integer.MAX_VALUE;
          int small_2=Integer.MAX_VALUE;

          for(int i=0; i<array_size; i++){
            if(array[i]<small_1){
                small_2=small_1;
                small_1=array[i];
            }else if (array[i]<small_2 && array[i]>small_1) {
                small_2=array[i];
            }
          }

          System.out.println("Small 1 : "+small_1);
          System.out.println("Small 2 : "+small_2);

    }
}
