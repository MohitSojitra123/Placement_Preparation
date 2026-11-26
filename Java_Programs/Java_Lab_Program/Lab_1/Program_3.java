// WAP to find a sum of even number 1D array
public class Program_3 {
     public static void main(String[] args) {

         int array1[]={10,20,30,40,50},sum=0;
        

          for(int i=0; i<array1.length; i++){
            if(array1[i] % 2 == 0){
                sum+=array1[i];
            }
          }

          System.out.println("Sum Of Array All Element => "+sum);
        }
}
