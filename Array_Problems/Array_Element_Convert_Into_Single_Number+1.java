import java.lang.ScopedValue.Carrier;
import java.util.ArrayList;
import java.util.Collections;

class Array_Element_Convert_Into_Single_Number_plush_1{
   public static void main(String[] args) {
    
      int array[]={9,6,8};

      ArrayList ar=new ArrayList<>();

      int Caree=1;

      for(int i=array.length-1; i>=0; i--){
        
           if((array[i]+Caree)<=9){
            ar.add(array[i]+Caree);  
            Caree=0;
           }else{
              ar.add(0);
              Caree=1;
           }
      }

      if(Caree==1){
           ar.add(1);
      }

      Collections.reverse(ar);

      System.out.println(ar);

   }    
}
