package HashSet;

import java.util.HashSet;

public class FindMissingElementUsingHashset {
    public static void main(String[] args) {
        
          int array[]={1,2,3,4,5,6,7,8,9,10,12};
          
          
          HashSet<Integer> set=new HashSet<>();

          for(int i=0; i<array.length; i++){
                 set.add(array[i]);
          }

          int missing=1;

          while (set.contains(missing)) {
              missing++;
          }

          System.out.println("Misssing Element Is : "+missing);

    }
}
