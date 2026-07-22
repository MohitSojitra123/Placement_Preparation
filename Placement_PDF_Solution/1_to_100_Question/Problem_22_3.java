import java.util.Scanner;

// ***********
// *****-*****
// ****---****
// ***-----***
// **-------**
// *---------*

public class Problem_22_3 {
    public static void main(String[] args) {
        
         Scanner sc=new Scanner(System.in);

          System.out.println("Enter N : ");
          int n=sc.nextInt();

          for(int i=1; i<=((n*2)+1); i++){
            System.out.print("*");
          }

          System.out.println();

          for(int i=1; i<=n; i++){

            for(int j1=i; j1<=n; j1++){
             System.out.print("*");
            }
            
            for(int space=1; space<=((i*2)-1); space++){
                System.out.print("-");
            }
            
            for(int j1=i; j1<=n; j1++){
             System.out.print("*");
            }
           

            System.out.println();
        }



    }
}
