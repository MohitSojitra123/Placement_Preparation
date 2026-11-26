// Given an array arr[], the task is to reverse the array. Reversing an array means rearranging the elements 
// such that the first element becomes the last, the second element becomes second last and so on. (Do 
// not use any additional Array) 
// Input: arr[] = {1, 4, 3, 2, 6, 5}   
// Output: {5, 6, 2, 3, 4, 1} 

public class Question_24 {
    public static void main(String[] args) {
        
          int array[]={1, 4, 3, 2, 6, 5};

          for(int i:array){
            System.out.print(i+" ");
          }
          System.out.println("\n-----------\n");

          int start=0;
          int end=array.length-1;

          while (start<end) {
              int Temp = array[start];
              array[start]=array[end];
              array[end]=Temp;
              start++;
              end--;
          }

          
          for(int i:array){
            System.out.print(i+" ");
          }
          System.out.println();

    }
}
