// 30 Given an array of positive integers arr[] of size n, the task is to find the second 
// largest distinct element in the array. 
// Note: If the second largest element does not exist, return -1. 
// Input: arr[] = [12, 35, 1, 10, 34, 1] 
// Output: 34 
// Explanation: The largest element of the array is 35 and the second largest element 
// is 34. 
// Input: arr[] = [10, 10, 10] 
// Output: -1 
// Explanation: The largest element of the array is 10 there is no second largest 
// element

public class Problem_30_1 {
    public static void main(String[] args) {
        
        int array[]={12, 35, 1, 10, 34, 1};
        // int array[]={10, 10, 10}; 


        int First_Big=Integer.MIN_VALUE;
        int Second_Big=Integer.MIN_VALUE;


        for(int i=0; i<array.length; i++){
               if(array[i]>=First_Big){
                Second_Big=First_Big;
                First_Big=array[i];
               }else if(array[i]>Second_Big && array[i]!=First_Big){
                    Second_Big=array[i];
               }
        }


        System.out.println("First Big : "+First_Big);
        System.out.println("Second Big : "+Second_Big);

        if(First_Big==Second_Big){
            System.out.println("Ans : "+-1);
        }else{
            System.out.println("Ans : "+Second_Big);
        }

    }
}
