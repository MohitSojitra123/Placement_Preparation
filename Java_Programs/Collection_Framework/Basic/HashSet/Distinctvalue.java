// Count distinct elements.

package HashSet;

import java.util.HashSet;

public class  Distinctvalue {
       public static void main(String[] args) {
            
               int array[]={1,2,3,4,5,4,3,2,1,6,7,8,9};

               HashSet<Integer> set=new HashSet<>();


               for(int i=0; i<array.length; i++){
                     if(set.contains(array[i])){
                            continue;
                     }else{
                              set.add(array[i]);
                     }
               }


               System.out.println(set);
  
       }
}