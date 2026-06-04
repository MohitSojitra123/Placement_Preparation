// 8 Given  an  array  arr[],  the  task  is  to  reverse  the  array.  Reversing  an  array  means 
// rearranging the elements such that the  first element becomes the last, the second 
// element becomes second last and so on. 
 
// Input: arr[] = {1, 4, 3, 2, 6, 5}   
// Output: {5, 6, 2, 3, 4, 1} 
 
// Input: arr[] = {4, 5, 1, 2}  
// Output: {2, 1, 5, 4} 

import java.util.Arrays;
import java.util.Scanner;

public class Problem_8 {
    public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);
        
    int array_size;

    System.out.println("Enter Array Size : ");
    array_size=sc.nextInt();

    int arr[]=new int[array_size];

    for(int i=0; i<array_size; i++){
        System.out.println("Enter Array Element  : ");
         arr[i]=sc.nextInt(); 
    }

    
    System.out.println("Array : "+Arrays.toString(arr));
    
    int start=0;
    int end=array_size-1;
    
    while (start<end) {
        int temp=arr[start];
        arr[start]=arr[end];
        arr[end]=temp;
        start++;
        end--;
    }
    
    System.out.println("Array : "+Arrays.toString(arr));
    
    }
}
