import java.util.HashMap;

public class Count_Character_Frequency {
    public static void main(String[] args) {
        
    String str="abcdef ghi jk abc ghi j j j k a a a ";

    HashMap<Character,Integer> HM=new HashMap<>();

    for(int i=0; i<str.length(); i++){
        if(str.charAt(i)==' '){
            continue;
        }
          if(HM.containsKey(str.charAt(i))){
              HM.put(str.charAt(i), HM.getOrDefault(str.charAt(i), 0)+1);
          }else{
            HM.put(str.charAt(i), 1);
          }
    }

    HM.forEach((k,v)->{
        System.out.println(k+"-> "+v);
    });

    }
}
