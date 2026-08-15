import java.lang.ScopedValue.Carrier;
import java.util.ArrayList;
import java.util.Collections;

class Array_Element_Convert_Into_Single_Number_plush_1{
   public static void main(String[] args) {
    
           int array[]={9,9,9,9};

       String str="";
       
       for(int i=0; i<array.length; i++){
           str+=array[i];
       }

       int num=Integer.parseInt(str)+1;

       System.out.println(num);

   }    
}
