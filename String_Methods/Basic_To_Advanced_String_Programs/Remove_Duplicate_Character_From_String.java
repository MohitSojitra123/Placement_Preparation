import java.util.HashSet;

public class Remove_Duplicate_Character_From_String {
    public static void main(String[] args) {
        

                String str="abcdef ghi jk abc ghi j j j k a a a ";

                HashSet<Character> hs=new HashSet<>();
        
                for(int i=0; i<str.length(); i++){
                    hs.add(str.charAt(i));
                }


                StringBuilder sb=new StringBuilder();

                for(char ch:hs){
                    sb.append(ch);
                }

                String str1=sb.toString();

                System.out.println(sb);
                System.out.println(str1);



    }
}
