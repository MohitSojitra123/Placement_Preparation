package HashSet;
import java.util.HashSet;

public class CheckContainDuplicateElement {
      public static void main(String[] args) {
        
          int array1[]={1,2,3,4,5,6,7};

          HashSet<Integer> hset=new HashSet<>();

          boolean flag=false;

          for(int i=0; i<array1.length;i++){
            if(hset.contains(array1[i])){
                flag=true;
                break;
            }else{
                 hset.add(array1[i]);
            }
          }

          if(flag){
            System.out.println("Duplicate Element Contain : ");
          }else{
            System.out.println("Duplicate Element Not Contain : ");
          }


      }
}
