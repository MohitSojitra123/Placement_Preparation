import java.util.Scanner;

public class Print_Duplicate_Array_Element {
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

      System.out.println();

      for(int i=0; i<array_size; i++){
        System.err.print(array[i]+"  ");
      }

      System.out.println();

      int Temp_array[]=new int[array_size];
      int count=1;

      System.out.println("Duplicate Element : ");

      for(int i=0; i<array_size-1; i++){
           if(Temp_array[i]==-1){
              continue;
           }else{
               for(int j=i+1; j<array_size; j++){
                  if(array[i]==array[j]){
                    count++;
                    Temp_array[j]=-1;
                  }
               }

               if(count>1){
                   System.out.println(array[i]+" ->  "+count);
               }

               count=1;
           }
      }


    }
}
