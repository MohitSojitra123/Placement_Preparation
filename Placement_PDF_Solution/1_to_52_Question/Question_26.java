// Find the difference between the second largest element and the second smallest element of an array. 
// Input :  Enter the size of array: 7 
//               Enter 7 elements: 5 1 9 7 1 5 3 
// Output: Difference: 4

public class Question_26 {
    public static void main(String[] args) {

         int array[]={5,1,9,7,1,5,3};

         int big_1=0;
         int big_2=0;
         int small_1=array[0];
         int small_2=array[0];

         for(int i=0; i<array.length; i++){

            if(big_1>array[i]){
                big_2=big_1;
                big_1=array[i];
            }else if(array[i] > big_2 && array[i] != big_1){
                big_2=array[i];
            }

            if(array[i]<small_1){
                small_2=small_1;
                small_1=small_2;
            }else if(array[i]<small_2 && small_1!=array[i]){
                   small_2=array[i];
            }
         }

         System.out.println(big_2-small_2);

    }
}
