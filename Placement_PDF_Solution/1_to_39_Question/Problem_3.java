// Pattern

import java.util.Scanner;

public class Problem_3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int user;

        System.out.println("Enter Number : ");
        user=sc.nextInt();

    int n=(user/2)+1;

    System.out.println();
    System.out.println();

        for(int i=1; i<=user; i++){
            for(int j=1; j<=user; j++){

                if((j==1 && i<=n)  ||  (j==n && i<=user) || (i==n && j<=n) || (i==1 && j>n) || (i==user && j<=n) || (i==n && j>n) || (j==user && i>n)){
                    System.out.print(" * ");
                }else{
                  System.out.print("   ");
                }

            }
            System.out.println();
        }

        
    System.out.println();
    System.out.println();


    }
}
