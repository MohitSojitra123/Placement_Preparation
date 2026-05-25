import java.util.Scanner;

class  Leader_Element{
    public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);

          int array_size;

          System.out.println("Enter Array Size : ");
          array_size=sc.nextInt();

          int array[]=new int[array_size];

          for(int i=0;  i<array_size; i++){
                 System.out.println("Enter Array Element : ");
                 array[i]=sc.nextInt();
          }

          int max=array[array_size-1];

          for(int i=array_size-2; i>=0; i--){
               if(array[i]>max){
                   System.out.println(array[i]);
                   max=array[i];
               }
          }


    }
}