// Input:
// arr = [17,18,5,4,6,1]


// [18,6,6,6,1,-1]

import java.util.Arrays;

public class Replace_Greter_Element {

    public static void main(String[] args) {
        
          int array[]={17,18,5,4,6,1};

          int new_array[]=new int[array.length];

          System.out.println(Arrays.toString(array));
          
          for(int i=0; i<array.length; i++){
              
            if(i!=array.length-1){
                int max_element=array[i+1];

                for(int j=i+1; j<array.length; j++){
                      if(array[j]>max_element){
                            max_element=array[j];
                      }
                }

                new_array[i]=max_element;

            }else{
                new_array[i]=-1;
            }

        }
        
        System.out.println(Arrays.toString(new_array));

    }
    
}