// Write an interactive program to print a string entered in a pyramid form. For instance,
// the string "stream" has to be displayed as follows
// s
// st
// str
// stre
// strea
// stream 

import java.util.Scanner;

public class Program_5 {
    public static void main(String[] args) {
    
         Scanner sc=new Scanner(System.in);

         System.out.println("Enter Any Strgin => ");
         String str=sc.nextLine();

         Program_5 p5=new Program_5();

         p5.print_pattern(str);
        
    }

    public static void print_pattern(String str){
            for(int i=0; i<str.length(); i++){
            for(int j=0; j<=i; j++){
                System.out.print(str.charAt(j)+" ");
            }
            System.out.println();
         }
    }


}
