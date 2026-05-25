import java.util.Scanner;

public class First_Two_Non_Repeating_Element {
      public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);

          int array_size;

        System.out.println("Enter Array size : ");
        array_size=sc.nextInt();
        
        int array[]=new int[array_size];

        for(int i=0; i<array_size; i++){
            System.out.println("Enter Array Element : ");
            array[i]=sc.nextInt();
        }

        System.out.println("\n\n");
        
        for(int i=0; i<array_size; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println("\n\n");

        int count=1,nonrepeatingcount=0;

        int Temp_array[]=new int[array_size];

        for(int i=0; i<array_size; i++){

            if(nonrepeatingcount==2){
                break;
            }

              if(Temp_array[i]==-1){
                continue;
              }else{
                  for(int j=i+1; j<array_size; j++){
                       if(array[i]==array[j]){
                             count++;
                             Temp_array[j]=-1;
                       }
                  }

                  if(count==1){
                      nonrepeatingcount++;
                       System.out.println(" Non Repeating Element : " +nonrepeatingcount  + " -> " +
                       array[i]);
                  }

                  count=1;

              }

        }




      }
}
