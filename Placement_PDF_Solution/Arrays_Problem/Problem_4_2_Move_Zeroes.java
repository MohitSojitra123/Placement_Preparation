import java.util.Arrays;

public class Problem_4_2_Move_Zeroes {
    public static void main(String[] args) {
        
         int array[]={1,3,2,0,8,90,7,6,0,8,9,0,7,9,0};
         
       int array2[]=new int[array.length];

         System.out.println(Arrays.toString(array));
         
         int current_index=0;

         for(int i=0; i<array.length; i++){
            if(array[i]!=0){
                array2[current_index++]=array[i];;
            }
         }
         

            System.out.println(Arrays.toString(array2));

    }
}
