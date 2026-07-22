import java.util.Arrays;

public class Problem_4_1_Move_Zeroes {
    public static void main(String[] args) {
        
         int array[]={1,3,2,0,8,90,7,6,0,8,9,0,7,9,0};
         
         int current_index=0;

         System.out.println(Arrays.toString(array));
         
         for(int i=0; i<array.length; i++){
             if(array[i]!=0){
                 int temp=array[i];
                 array[i]=0;
                 array[current_index++]=temp;
                }
            }

            System.out.println(Arrays.toString(array));

    }
}
