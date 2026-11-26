// Write a Java program to sum values of an array.

public class Program_1{
   public static void main(String[] args) {
    
       int array[]={10,20,30,40,50};

       Program_1 p1=new Program_1();

     int result=p1.array_sum(array);

       System.out.println("Sum Of Array Element => "+result);
    
   }

    public static int array_sum(int[] array){
           int sum=0;   
        for(int i=0; i<array.length; i++){
                sum+=array[i];
           }
           return sum;
    }

}