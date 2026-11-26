// Remove duplicate characters from string.

package HashSet;

import java.util.Collection;
import java.util.HashSet;

public class RemoveDuplicateCharacter {
    public static void main(String[] args) {
        
          String str="abcxyzabcxyzpqr";

          char ch[]=str.toCharArray();

          HashSet<Character> set=new HashSet<>();

          for(int i=0; i<str.length(); i++){
            
              if(set.contains(ch[i])){
                  continue;
              }else{
                  set.add(ch[i]);
              }
          }



          StringBuilder sb=new StringBuilder();

          for(char c:set){
              sb.append(c);
          }

          System.out.println(sb);
    }
}
