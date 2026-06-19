// For n=4 
// 1 
// 2   5 
// 3   6   8 
// 4   7   9  10

import java.util.Scanner;

public class Question_11 {
    public static void main(String[] args) {
       
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter N : ");
        int n=sc.nextInt();

        int current_val=0;
        
        for(int i=1; i<=n; i++){
            int unique=n-1;
            current_val=i;
            for(int j=i; j<=(i*2)-1; j++){
                if(i==j){
                    System.out.print(i+" ");
                }else{
                  current_val =  current_val+unique;
                      System.out.print(current_val+" ");
                      unique--;
                }
            }
            System.out.println();
        }
        
    }
}
