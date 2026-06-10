package Day_2;

import java.util.Scanner;

public class Serice {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);


        System.out.println("Enter N : ");
        int n=sc.nextInt();

        int sum=0;

        for(int i=1; i<=n; i++){
                for(int j=1; j<=i; j++){
                    sum+=j;
                }
        }

        System.out.println("Sum : "+sum);

    }
}
