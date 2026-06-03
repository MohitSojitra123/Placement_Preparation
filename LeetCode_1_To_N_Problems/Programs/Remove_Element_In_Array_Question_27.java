public class Remove_Element_In_Array_Question_27 {
    public static void main(String[] args) {
        
          int array[]={2,5,6,8,2,5,9,10,14,5,2,2,2,2,2,6,2,57,97,2};


          int val=2;

          int array_size=array.length;

          for(int i=0; i<array_size; i++){
              if(array[i]==val){
                   for(int j=i; j<array_size-1; j++){
                      array[j]=array[j+1];
                   }
                   array_size--;
                   i--;
              }
          }

          System.out.println("\n\n");
          for(int i=0; i<array_size; i++){
            System.out.print(array[i]+" ");
          }
          System.out.println("\n\n");


    }
}
