package HashSet;

import java.util.HashSet;

// Check pangram string.

// Contains a to z all Character ato z one Time Allowe Compulsary and More Than One Is Allowed 

public class Panagram_String {
    public static void main(String[] args) {
        
    String str = "The quick brown fox jumps ovear the lazy dog";

    str=str.toLowerCase();

    HashSet<Character> set=new HashSet<>();

      for(int i=0; i<str.length(); i++){   
        if(str.charAt(i)>='a' && str.charAt(i)<='z'){
             set.add(str.charAt(i));
        }  
        }


        if(set.size()==26){
           System.out.println("Given String Is Panagram : ");
        }else{
            System.out.println("Given String Is Not Panagram : ");
        }




    }
}
