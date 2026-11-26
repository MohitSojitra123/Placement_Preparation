// Given  two  arrays  a[]  and  b[],  the  task  is  to  find  the  intersection  of  the  two  arrays. 
// Intersection of two arrays is said to be elements that are common in both arrays. The 
// intersection should not count duplicate elements and the result should contain items 
// in any order. 
 
// Input: a[] = {1, 2, 1, 3, 1},  b[] = {3, 1, 3, 4, 1} 
// Output: {1,  3} 
// Explanation: 1 and 3 are the only common elements and we need to print only one 
// occurrence of common elements. 
// Input: a[] = {1, 1, 1},  b[] = {1, 1, 1, 1, 1} 
// Output: {1} 
// Explanation: 1 is the only common element present in both the arrays. 
// Input: a[] = {1, 2, 3},  b[] = {4, 5, 6} 
// Output: {} 
// Explanation: No common element in both the arrays. 

import java.util.HashSet;

public class Problem_36 {
    public static void main(String[] args) {
        
        int a[]={1, 2, 1, 3, 1};
        int b[] = {3, 1, 3, 4, 1}; 

        HashSet<Integer> a1=new HashSet<>();
        HashSet<Integer> b1=new HashSet<>();

        for(int i=0; i<a.length; i++){
            if(!a1.contains(a[i])){
                  a1.add(a[i]);
            }
        }

        for(int i=0; i<b.length; i++){
             if(!b1.contains(b[i])){
                b1.add(b[i]);
             }
        }

        System.out.print("[");
        
        for(int i : a1){
            if(b1.contains(i)){
                System.out.print(i+" ");
            }
        }
        
        System.out.print("]");



    }
}
