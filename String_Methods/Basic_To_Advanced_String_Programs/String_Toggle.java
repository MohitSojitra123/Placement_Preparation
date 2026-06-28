package Basic_To_Advanced_String_Peograms;
import java.util.Scanner;

public class String_Toggle {
    public static void main(String[] args) {
        
          String str=new String("Mo45HiT");

          for(int i=0; i<str.length(); i++){
             if(str.charAt(i)==' ' ){
                      continue;
             }else{
                  if(Character.isAlphabetic(str.charAt(i))){
                      if(str.charAt(i)>='A' && str.charAt(i)<='Z'){
                           char ch=(char)(str.charAt(i) + 32);
                          str=str.substring(0, i) + ch  + str.substring(i+1);
                        }else{
                             char ch=(char)(str.charAt(i) - 32);
                            str=str.substring(0, i) + ch + str.substring(i+1);
                        }
                    }
                }
          }

          System.out.println(str);

    }
}
