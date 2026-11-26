import java.util.ArrayList;

public class Permutation {
    
    static ArrayList<String> arr=new ArrayList<>();

    static void find_Permutation(String s,String ans){
        if(s.length()==0){
            arr.add(ans);
        }else{

            for(int i=0; i<s.length(); i++){   
                char ch=s.charAt(i);
                String left=s.substring(0, i);
                String right=s.substring(i+1);

                find_Permutation(left+right, ans+ch);
            }
        }
    }

    public static void main(String[] args) {
        
          String str="Mohit";


          Permutation.find_Permutation(str, "");

          System.out.println(arr);

          System.out.println(arr.size());


    }
}
