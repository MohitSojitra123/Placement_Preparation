// Given a string that contains a special character together with alphabets (‘a’ to ‘z’ and ‘A’ to ‘Z’), reverse 
// the string in a way that special characters are not affected. 
// Input: a!!!b.c.d,e'f,ghi 
// Output: i!!!h.g.f,e'd,cba 
// Input:   str = “Ab,c,de!$” 
// Output:  str = “ed,c,bA!$

import java.util.Arrays;

public class Question_50 {
    
      public static void main(String[] args) {
        
          String str="a!!!b.c.d,e'f,ghi";

          str=str.toLowerCase();

          int start=0;
          int end=str.length()-1;

          char str_char[]=str.toCharArray();

          System.out.println(str);


          while (start<=end) {
               if(str_char[start]>='a' && str_char[end]<='z'){
                   if(str_char[end]>='a' && str_char[end]<='z'){
                       char temp=str_char[start];
                       str_char[start]=str_char[end];
                       str_char[end]=temp;

                       start++;
                       end--;
                   }else{
                      end--;
                   }
               }else{
                start++;
               }   
          }

          str="";
        
          for(char c:str_char){
            str+=c;
          }

          System.out.println(str);


      }

}
