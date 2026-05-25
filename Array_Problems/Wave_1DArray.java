import java.lang.reflect.Array;
import java.util.Arrays;

public class Wave_1DArray {
    public static void main(String[] args) {
          
        int array[]={10,20,30,40,50,60,70};

        
        System.out.println(Arrays.toString(array));


        for(int i=0; i<array.length-1; i+=2){
           int temp=array[i];
           array[i]=array[i+1];
           array[i+1]=temp;
        }

        System.out.println(Arrays.toString(array));

    }
}
