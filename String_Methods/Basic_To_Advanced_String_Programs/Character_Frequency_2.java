import java.lang.reflect.Array;
import java.util.Arrays;

public class Character_Frequency_2 {
    
    public static void main(String[] args) {
        

         String str="prmogramming";

         char ch[]=str.toCharArray();
         int temp[]=new int[ch.length];

         for(int i=0; i<ch.length; i++){
            
               int current_count=1;
            
               if(temp[i]==-1){
                  continue;
               }else{

                   
                   for(int j=0; j<ch.length; j++){      
                       if(temp[j]==-1 || i==j){
                           continue;
                        }else if(ch[i]==ch[j]){
                            current_count++;
                            temp[j]=-1;
                        }
                    }

                    System.out.println(ch[i]+" -->  "+current_count);

                }

         }


    }

}
