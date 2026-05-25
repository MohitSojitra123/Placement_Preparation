// Write a program to print given array in reverse order.


public class Program_3 {
    public static void main(String[] args) {
        
        int array[]={10,20,30,40,50,60,70,80,90,100};
        
             Program_3 p3=new Program_3();

             p3.reverse_array(array);

      }

      public static void reverse_array(int array[]){
          for(int i=array.length-1; i>=0; i--){
               System.out.print(array[i]+"-");
          }     
      }

}
