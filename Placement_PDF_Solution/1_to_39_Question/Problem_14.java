// Given a string that contains a special character together with alphabets (‘a’ to ‘z’ and 
// ‘A’ to ‘Z’), reverse the string in a way that special characters are not affected.  
// Input: a!!!b.c.d,e'f,ghi 
// Output: i!!!h.g.f,e'd,cba  
// Input:   str = “Ab,c,de!$” 
// Output:  str = “ed,c,bA!$”

public class Problem_14 {
    public static void main(String[] args) {
        
        
        //   String str=" a!!!b.c.d,e'f,ghi ";
        String str="Ab,c,de!$";

          char ch[]=str.toCharArray();

          int start=0;
          int end=ch.length-1;

          while (start<=end) {

              if( (ch[start]>='a' && ch[start]<='z')  || (ch[start]>='A' && ch[start]<='Z')  ){
                      if((ch[end]>='a' && ch[end]<='z')  || (ch[end]>='A' && ch[end]<='Z')){
                            char temp=ch[end];
                            ch[end]=ch[start];
                            ch[start]=temp;
                             start++;
                            end--;
                      }else{
                          end--;
                      } 
              }else{
                     start++;
              }
          }
          
          String final_str=new String(ch);


          System.out.println(final_str);

    }
}

// Character.isLetter(ch)      // A-Z, a-z, and other language letters
// Character.isDigit(ch)       // 0-9
// Character.isLetterOrDigit(ch)
// Character.isUpperCase(ch)
// Character.isLowerCase(ch)