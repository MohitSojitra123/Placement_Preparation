// Given an array, rotate the array to the right by k steps, where k is non-negative.  
// Input: nums = [1,2,3,4,5,6,7], k = 3 
// Output: [5,6,7,1,2,3,4] 

public class Question_23 {
   
    public static void rotate(int array[],int start,int end){
        
          while (start<end) {
             int temp=array[start];
             array[start]=array[end];
             array[end]=temp;
             start++;
             end--;
          }
    }
   
    public static void main(String[] args) {
    
       int array[]={1,2,3,4,5,6,7};

       int k=3;

        for(int i:array){
        System.out.print(i+" ");
        }

        System.out.println("\n---------------------\n");

       rotate(array, 0, k);
       rotate(array, k+1, array.length-1);
       rotate(array, 0, array.length-1);

       for(int i:array){
        System.out.print(i+" ");
       }


   }
}
