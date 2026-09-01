import java.util.Arrays;

class Moves_Zero_Right_Side{
    public static void main(String[] args) {
 
          int array[]={0,0,1,2,4,5,2,0,0,1,4,0,5,4,0,2,0,5,4,6,0,2,1};

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