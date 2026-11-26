import java.time.temporal.Temporal;

public class Longest_Palindromic_Sub_String {


            public static boolean Check_Palindrom_str(String s1){

                int left=0;
                int right=s1.length()-1;

                while (left<right) {
                    if(s1.charAt(left)!=s1.charAt(right)){
                        return false;
                    }
                    left++;
                    right--;
                }
                return true;
            }

    public static void main(String[] args) {

        //   String str="cbbd";
          String str="bbbab";

          String Longest_Palindrom_str="";

          for(int i=0; i<str.length(); i++){
            for(int j=i+1; j<=str.length(); j++){
                String temp=str.substring(i, j);

                if(Check_Palindrom_str(temp)){
                       if(temp.length()>Longest_Palindrom_str.length()){
                            Longest_Palindrom_str=temp;
                       }
                }
            }
          }

          System.out.println(Longest_Palindrom_str);

    }
}
