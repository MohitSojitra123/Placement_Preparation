// Rules : 
// Use Only Single Loop
// Number Is only 1 to n+1 No Other Number Contain 

import java.lang.reflect.Array;
import java.util.Arrays;

public class Find_Repeated_Element_Using_Single_Loop {
    public static void main(String[] args) {
        
        int array[]={1,2,3,4,5,6,7,4};

        int check_array[]=new int[array.length];

        Arrays.fill(check_array, 0);

        for(int i=0; i<array.length; i++){
            if(check_array[array[i]]==0){
                check_array[array[i]]++;
            }else{
                System.out.println("Repeated Element : "+array[i]);
                break;  
            }
        }

      

    }
}
