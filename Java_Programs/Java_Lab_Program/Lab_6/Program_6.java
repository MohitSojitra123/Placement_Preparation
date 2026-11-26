// Write a program to find length of string and print second half of the string.

import java.util.Scanner;

class string_method{
    public void String_cut(){
          Scanner sc=new Scanner(System.in);
          
          System.out.println("Enter String To Print Half Strgin => ");
          String str=sc.nextLine();
          
          System.out.println(str.substring(0,(str.length()/2)));
     }
}

public class Program_6 {
     public static void main(String[] args) {
        
          string_method str_cut=new string_method();
          str_cut.String_cut();
            
     } 
}
