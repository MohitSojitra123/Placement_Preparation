// Given two integer arrays nums1 and nums2, return an array of their intersection.  
// Each element in the result must appear as many times as it shows in both arrays and you may return the 
// result in sorted order

import java.util.HashSet;

public class Question_18 {
    public static void main(String[] args) {
        
        int array1[]={1,2,3,4,5,6,2,4,6};
        int array2[]={1,2,3,4,5,4,6,5};


        for(int i=0; i<array1.length; i++){
                for(int j=0; j<array2.length; j++){
                    if(array1[i]==array2[j]){
                        System.out.print(array1[i]+" ");
                        break;
                    }
                }
        }



    }
}
