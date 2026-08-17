import java.util.HashSet;

public class Substring_Count_3_Character_Contain {

       public static boolean isPalindrom(String str){
                    int left=0;
                    int right=str.length()-1;

                    while (left<right) {
                        
                         if(str.charAt(left)==str.charAt(right)){
                            left++;
                            right--;
                         }else{
                            return false;
                         }

                    }

                    return true;
       }

    public static void main(String[] args) {
     
        // String str="bbcbaba";
        String str="aabca";

        HashSet<String> hs=new HashSet<>();

        for(int i=0; i<str.length(); i++){
            for(int j=i+1; j<str.length(); j++){
                for(int k=j+1; k<str.length(); k++){
                    
                    String temp=""+str.charAt(i)+str.charAt(j)+str.charAt(k);

                      if(isPalindrom(temp)){
                            hs.add(temp);
                      }
                }
            }
        }
        
        System.out.println("Size : " + hs.size());
        System.out.println(hs);

    }
    
}