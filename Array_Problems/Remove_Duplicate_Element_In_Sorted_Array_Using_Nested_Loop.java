import java.lang.reflect.Array;
import java.util.Arrays;

public class Remove_Duplicate_Element_In_Sorted_Array_Using_Nested_Loop {
   public static void main(String[] args) {
    
        int array[] = {
            1, 1, 2, 3, 4, 5, 5, 5, 6, 7, 8, 8, 8,
            9, 10, 10, 10, 10, 10, 11, 12, 12, 12, 12, 12
        };

        System.out.println(Arrays.toString(array));
        
        int size=array.length;
        
        for(int i=0; i<size-1; i++){
            if(array[i]==array[i+1]){
                for(int j=i+1; j<size-1; j++){
                        array[j]=array[j+1];
                    }
                    size--;
                    i--;
                }
            }


            System.out.println(Arrays.toString(Arrays.copyOf(array, size)));

   }    
}
