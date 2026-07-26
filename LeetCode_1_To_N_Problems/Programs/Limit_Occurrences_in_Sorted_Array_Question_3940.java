import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Limit_Occurrences_in_Sorted_Array_Question_3940_1{
    public static void main(String[] args) {
        
        int array[]={1,1,1,2,2,3};
        int k=2;

        HashMap<Integer,Integer> hm=new HashMap<>();

        for(int i=0; i<array.length; i++){
            if(hm.containsKey(array[i])){
                hm.put(array[i], hm.getOrDefault(array[i], 0)+1);
            }else{
                hm.put(array[i], 1);
            }
        }

        ArrayList<Integer> ar=new ArrayList<>();

          hm.forEach((key,val)->{
              if(val>=k){
                  for(int i=1; i<=k; i++){
                    ar.add(key);
                  }
              }else{
                ar.add(key);
              }
          });


          int ans[]=new int[ar.size()];

          for(int i=0; i<ans.length; i++){
              ans[i]=ar.get(i);
          }

          System.out.println(Arrays.toString(ans));

    }
}