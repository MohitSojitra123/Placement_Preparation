import java.util.Scanner;

public class Second_Lagest_Element {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Array Size  : ");
        int array_size=sc.nextInt();

        int array[]=new int[array_size];

         for(int i=0; i<array_size; i++){
             System.out.println("Enter Array Element  : ");
             array[i]=sc.nextInt();
         }

         int largest_1=Integer.MIN_VALUE;
         int largest_2=Integer.MIN_VALUE;

         for(int i=0; i<array_size; i++){
              if(array[i]>largest_1){
                  largest_2=largest_1;
                  largest_1=array[i];
              }else if(array[i]>largest_2 && array[i]!=largest_1){
                largest_2=array[i];
              }
         }
         
         System.out.println("Largest Number 1 "+largest_1);
         System.out.println("Largest Number 2 "+largest_2);


    }
}
