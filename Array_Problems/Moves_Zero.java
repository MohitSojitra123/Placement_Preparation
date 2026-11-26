import java.util.Arrays;

public class Moves_Zero {
    public static void main(String[] args) {
        
          int array[]={0,0,1,2,4,5,6,0,1,4,5,6,1,8,9,0,0,1,2,0};

          System.out.println(Arrays.toString(array));
          
          int current_index=0;
          
          for(int i=0; i<array.length; i++){
              if(array[i]!=0){
                  int temp=array[i];
                  array[i]=array[current_index];
                  array[current_index]=temp;
                  current_index++;
                }
            }
            
            System.out.println(Arrays.toString(array));

    }
}
