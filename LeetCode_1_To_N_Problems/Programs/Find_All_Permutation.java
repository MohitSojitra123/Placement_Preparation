import java.util.ArrayList;

class Find_All_Permutation{

     
       static ArrayList<String> arr=new ArrayList<>();

         void  permutation(String s,String ans){
            
              if(s.length()==0){
                 arr.add(ans);   
                return;
              }

              for(int i=0; i<s.length(); i++){
                   char ch=s.charAt(i);

                   String left=s.substring(0, i);
                   String right=s.substring(i+1);

                   permutation(left+right, ans+ch);

              }

         }
      
    public static void main(String[] args) {
        
        String str="abcd";

        Find_All_Permutation fp=new Find_All_Permutation();

        fp.permutation(str, "");

        System.out.println(arr);

        System.out.println(arr.size());

    }
}