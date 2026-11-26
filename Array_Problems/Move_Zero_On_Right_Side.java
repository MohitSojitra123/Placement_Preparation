import java.util.Arrays;

class Move_Zero_On_Right_Side{
    public static void main(String[] args) {
        
        int array[]={1,3,0,6,0,2,5,0,0,1,4,0,5,3,0,6,5};

        int ans[]=new int[array.length];

        int current_index=0;

        for(int i=0; i<array.length; i++){
            if(array[i]!=0){
                ans[current_index++]=array[i];
            }
        }

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(ans));


    }
}