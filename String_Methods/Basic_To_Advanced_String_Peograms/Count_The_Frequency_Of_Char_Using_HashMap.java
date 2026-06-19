package Basic_To_Advanced_String_Peograms;
import java.util.HashMap;

class Count_The_Frequency_Of_Char_Using_HashMap{
    public static void main(String[] args) {
        
        String str="sojitraa mohit ";

        HashMap<Character,Integer> hm=new HashMap<>();


        char ch[]=str.toCharArray();

        for(int i=0; i<ch.length; i++){

             if(ch[i]==' '){
                 continue;
             }else{
                 if(hm.containsKey(ch[i])){
                     hm.put(ch[i], hm.get(ch[i]) + 1);       
                     //   hm.put(ch[i], hm.getOrDefault(ch[i], 0) + 1);
                    }else{
                        hm.put(ch[i], 1);
                    }
                }
                }

        System.out.println(hm);


    }
}