import java.util.HashMap;

public class Count_Frequency_Of_Array {
    public static void main(String[] args) {

        int array[]={10,20,30,40,50,50,30,10,30,50,10,10};

        HashMap<Integer,Integer> hm=new HashMap<>();

        for(int i=0; i<array.length; i++){
            if(hm.containsKey(array[i])){
                 hm.put(array[i], hm.getOrDefault(array[i], 0)+1);
            }else{
                hm.put(array[i], 1);
            }
        }
        
        // for(int i : hm.values()){
             
        // }

        // for(int j: hm.keySet()){

        // }


        hm.forEach((k,v)->{
            System.out.println(k+" --> "+v);
        });

    }
}
