// Write  a  Function  that  returns  either  1  or  0  based  on  following  condition  if  the  array  is  in 
// ascending order and occurrence of that number at least 3 then it should return 1 otherwise 
// it should return 0. 
// e.g.  
// if A=[1,1,1,2,2] it should return 0 
// if A=[1,1,1,3,3,3,3] it should return 1 
// if A=[2,2,2,1,1,1] it should return 0

import java.util.HashMap;

public class Problem_57 {
    public static void main(String[] args) {
     
        int array[]={1,1,1,3,3,3,3};

        HashMap<Integer,Integer> hm=new HashMap<>();

        for(int i=0; i<array.length; i++){
            
                if(hm.containsKey(array[i])){
                      hm.put(array[i], hm.get(array[i])+1);
                }else{
                      hm.put(array[i], 1);
                }
        }

        boolean isValid=true;

        for (int val : hm.values()){
              if(val<3){
                isValid=false;
                break;
              }
        }

        if(isValid){
            System.out.println(1);
        }else{
            System.out.println(0);
        }


        // for(int val : hm.values()){
        //        System.out.println(val);
        // }

        // for(int key : hm.keySet()){
        //     System.out.println(key);
        // }

//         for (var entry : hm.entrySet()) {
//     System.out.println(entry.getKey() + " -> " + entry.getValue());
// }

        
    }
}
