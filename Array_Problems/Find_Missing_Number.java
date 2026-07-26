public class Find_Missing_Number {
    public static void main(String[] args) {

          int array[]={1,2,3,4,5,6,7};
          
          int n=array.length;

          int sum=(n+1)*((n+1)+1)/2;

          int array_sum=0;

          for(int i=0; i<array.length; i++){
             array_sum+=array[i];
          }

          System.out.println("Array Missing Value : "+(sum-array_sum));

        
    }
}
