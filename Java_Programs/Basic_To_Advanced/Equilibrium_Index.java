import java.util.Scanner;

public class Equilibrium_Index {
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
              System.out.print(array[i]+"  ");
            }
            System.out.println("\n\n");

            for(int i=0; i<array_size; i++){
      
                 int Remaining_Element_Sum=0;

                  for(int j=i+1; j<array_size; j++){
                         Remaining_Element_Sum+=array[j]; 
                  }
           
                   if(Remaining_Element_Sum==array[i]){
                        System.out.println("Equilibrium Index Is : "+ i +" Equilibrium Element Is :  "+array[i]);
                   }
            }

    }
}
