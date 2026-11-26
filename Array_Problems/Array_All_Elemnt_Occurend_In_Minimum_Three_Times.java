public class Array_All_Elemnt_Occurend_In_Minimum_Three_Times {
    public static void main(String[] args) {
        
          int array[]={1,1,1,1,1,1,2,2,2,2,2,3,3,3,3,3,4,4,4,5,5,5};

          int count=1;

          boolean flag=true;

          for(int i=1; i<array.length; i++){
               if(array[i]==array[i-1]){
                    count++;      
               }else{
                  if(count<3){
                    flag=false;
                       break;
                  }else{
                    count=1;
                  }
               }
          }

          if(count<3){
            flag=false;
          }

          if(flag){
            System.out.println("Array FullField All Condition : ");
          }else{
            System.out.println("Array Not FullField All Condition : ");
          }

    }
}
