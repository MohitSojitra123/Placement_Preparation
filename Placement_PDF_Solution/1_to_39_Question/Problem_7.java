// Given a number n then print n terms of fibonacci series in reverse order. 
 
// Input : n = 5 
// Output : 3 2 1 1 0 
 
// Input : n = 8 
// Output : 13 8 5 3 2 1 1 0

import java.util.ArrayList;
import java.util.Scanner;

public class Problem_7 {
    public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);

          int n;

          System.err.println("Enter N : ");
          n=sc.nextInt();

          ArrayList<Integer> ar=new ArrayList<>();

          int a=0;
          int b=1; 
          int c=0;

          for(int i=1; i<=n; i++){
               ar.add(a);
                c=a+b;
                a=b;
                b=c;
          }

          for(int i=ar.size()-1; i>=0; i--){
            System.out.print(ar.get(i)+" ");
          }

    }
}
