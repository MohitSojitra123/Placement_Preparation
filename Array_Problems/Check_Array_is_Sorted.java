public class Check_Array_is_Sorted {
    public static void main(String[] args) {

              int array[]={10,23,45,67};

              boolean isSorted=true;

              for(int i=1; i<array.length; i++){
                   if(array[i-1]>array[i]){
                      isSorted=false;
                    break;
                   }
              }

              if(isSorted){
                System.out.println("Array Is Sorted : ");
              }else{
                System.out.println("Array Is Not Sorted : ");
              }
        
    }
}
