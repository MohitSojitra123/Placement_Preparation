package HashSet;

public class Missing_Integer {
   public static void main(String[] args) {
    
       int array[]={1,2,4,3,5,7};

       int n=array.length+1;

       int actual_sum=n*(n+1)/2;

       int array_sum=0;

       for(int i=0; i<array.length; i++){
            array_sum+=array[i];
       }

       System.out.println("Missing Element Is : "+(actual_sum-array_sum));



   }    
}
