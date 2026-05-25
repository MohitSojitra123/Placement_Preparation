// Write a Java program to copy all the elements of an array to another array and print
// both the array elements.

public class Program_4 {
     public static void main(String[] args) {
        
          int array[]={10,20,30,40,50};

          Program_4 p4=new Program_4();

           int revese_arr[]=new int[array.length];  

          revese_arr=p4.copy_array(array);

          for(int i:revese_arr){
            System.out.print(i+" ");
          }

     }
     
        public static int[] copy_array(int array[]){

              int array2[]=new int[array.length];

                for(int i=0; i<array.length; i++){
                     array2[i]=array[i];
                }
                return array2;
        } 

}
