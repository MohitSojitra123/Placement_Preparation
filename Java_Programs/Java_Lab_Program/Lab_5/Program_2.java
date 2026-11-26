// Write a program that creates and initializes a four integer element array. Calculate and
// display the average of its values.

public class Program_2 {
      public static void main(String[] args) {

             int array[]={10,20,30,40};
             
             Program_2 p2=new Program_2();

             int result=p2.array_avg(array);

             System.out.println("Array Element Avg => "+result);
      }

       public static int array_avg(int[] array){
        int sum=0;
           for(int i=0; i<array.length; i++){
                   sum+=array[i];
             }
             return (sum/array.length);
       }

}
