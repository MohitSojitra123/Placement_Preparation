import java.util.Arrays;

public class Sort_Array_By_Parity_Question_905{
    public static void main(String[] args) {
        
          int array[]={3,1,2,4};

          int left=0;
          int right=array.length-1;

          System.out.println(Arrays.toString(array));


            
          while (left<right) {
            
               if(array[left]%2!=0){
                
                
                while (left<right){
                     if(array[right]%2==0){
                        break;
                     }else{
                        right--;
                     }
                }

                int temp=array[left];
                array[left]=array[right];
                array[right]=temp;

                left++;
               }else{
                left++;
               }

          }


          System.out.println(Arrays.toString(array));

    }
}
