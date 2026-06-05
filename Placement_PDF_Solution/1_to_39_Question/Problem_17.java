// 17 Given  an  array  arr[],  the  task  is  to  find  the  subarray  that  has  the  maximum  sum  and 
// return its sum.  
// Input: arr[] = {2, 3, -8, 7, -1, 2, 3} 
// Output: 11 
// Explanation: The subarray {7, -1, 2, 3} has the largest sum 11.  
// Input: arr[] = {5, 4, 1, 7, 8} 
// Output: 25 
// Explanation: The subarray {5, 4, 1, 7, 8} has the largest sum 25.

public class Problem_17 {
    public static void main(String[] args) {
        
        //   int array[]={2, 3, -8, 7, -1, 2, 3};
          int array[]={5, 4, 1, 7, 8};

          int max_sum=Integer.MIN_VALUE;
          int sum=0;
     

          for(int i=0; i<array.length; i++){
                 sum=array[i];
                    for(int j=i+1; j<array.length; j++){
                           sum+=array[j];
                    }
                    if(sum>max_sum){
                        max_sum=sum;
                    }
          }
        
          System.out.println("Sub Array Larget Sum : "+max_sum);

    }
}
