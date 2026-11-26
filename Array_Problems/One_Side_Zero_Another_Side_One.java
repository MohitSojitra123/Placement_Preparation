import java.lang.reflect.Array;
import java.util.Arrays;

public class One_Side_Zero_Another_Side_One {
  public static void main(String[] args) {
    
      int array[]={1,0,0,0,1,1,0,1,0,1,0,1,0,1,0,1,0,1,0,0,0,0,0,1,1,1,0,0,0,1,1,1,0,0,};


      System.out.println(Arrays.toString(array));
      
      
      int start=0;
      int end=array.length-1;
      
      while (start<end) {
          
          if(array[start] == 0){
              start++;
            }else if (array[end]==1) {
                end--;
            }
            else if(array[start]==1 && array[end]==0){
                array[start]=0;
                array[end]=1;
                start++;
                end--;
            }
        }
        
        System.out.println(Arrays.toString(array));

  }
}