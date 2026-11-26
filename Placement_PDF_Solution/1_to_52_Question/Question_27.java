// WAP for given N digits, arrange them to form the largest number divisible by 3. 

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Question_27 {
    public static void main(String[] args) {
        
          
        int num=8176;

        ArrayList<Integer> new_arr=new ArrayList<>();

        boolean flag=true;
        
        while(flag){            
            int sum=0;
            
            while (num!=0) {
                int last_number=num%10;
                new_arr.add(last_number);
                num/=10;
            }
            
            
            for(int i=0; i<new_arr.size()-1; i++){
                for(int j=0; j<new_arr.size()-1-i; j++){
                    if(new_arr.get(j)<new_arr.get(j+1)){
                        int temp=new_arr.get(j);
                        new_arr.set(j,new_arr.get(j+1));
                        new_arr.set(j+1,temp);
            }
        }
    }
    
         for(int i=0; i<new_arr.size(); i++){
             sum+=new_arr.get(i);
         }

         if(sum%3==0){
             System.out.println(new_arr.toString());
             flag=false;
            }else{
                new_arr.removeLast();
            }
            
        }
           


    }
}
