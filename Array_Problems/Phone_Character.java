import java.util.ArrayList;

public class Phone_Character {
    public static void main(String[] args) {
        
                 int[] arr = {2, 3};

        String[] keypad = {
                "", "", "abc", "def",
                "ghi", "jkl", "mno",
                "pqrs", "tuv", "wxyz"
        };

   
        char str1[]=keypad[2].toCharArray();
        char str2[]=keypad[3].toCharArray();


        ArrayList<String> ans=new ArrayList<>();

        for(int i=0; i<str1.length; i++){
            for(int j=0; j<str2.length; j++){
                ans.add(str1[i]+""+str2[j]+"");
            }
        }

        System.out.println(ans);
        


    }
}
