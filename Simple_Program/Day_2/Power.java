package Day_2;

import java.util.Scanner;

public class Power {
      public static void main(String[] args) {
        
           Scanner sc=new Scanner(System.in);

           System.out.println("Enter X : ");
           int x=sc.nextInt();

           System.out.println("Enter Y : ");
           int y=sc.nextInt();

           int ans=1;
           int temp=0;

           for(int i=1; i<=y; i++){
            temp=0;
            for(int j=1; j<=x; j++){
              temp+=ans;
            }
            ans=temp;
           }

           System.out.println(ans);

      }
}
