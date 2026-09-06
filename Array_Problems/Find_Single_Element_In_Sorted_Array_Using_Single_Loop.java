public class Find_Single_Element_In_Sorted_Array_Using_Single_Loop {
    public static void main(String[] args) {
        
        //   All The Element Occured Exact 2 Time  Occured Only One Element Occured In One Time...

        //   int array[]={1,1,2,2,3,3,4,4,5,5,6,6,7,8,8,9,9};
          int array[]={1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10};

           int count=1;

           for(int i=0; i<array.length; i++){
            
               if(array.length-1 == i){
                   System.out.println("Single Element Is : "+array[i]);
                   return; 
               }

               if(array[i]==array[i+1]){
                   count++;
                }else{
                    if(count!=2){
                        System.out.println("Single Element Is : "+array[i]);
                        return;
                    }else{
                      count=1;
                  }
              }

           }

    }
}
