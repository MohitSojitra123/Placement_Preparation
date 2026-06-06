// 29 Write a program to find and print the elements that are non-duplicate (i.e., unique) 
// between two arrays. 
// An  element  is  considered  non-duplicate if  it  appears  in  only  one of the  two  arrays, 
// but not in both. 
// Input: arr1: 1 2 3 4 
//             arr2: 3 4 5 6 
// Output: 1 2 5 6

import java.util.ArrayList;
import java.util.HashSet;

public class Problem_29_1{
  public static void main(String[] args) {

      int arr1[]={1,2,3,4};
      int arr2[]={3,4,5,6}; 
    
     
      HashSet<Integer> hs1=new HashSet<>();
      HashSet<Integer>  hs2=new HashSet<>();


      for(int a:arr1){
          hs1.add(a);
      }

      
      for(int a:arr2){
          hs2.add(a);
      }

    
      for(Integer ele:hs1){
             if(!hs2.contains(ele)){
                    System.out.print(ele+" ");
             }
      }

      for(Integer ele:hs2){
        if(!hs1.contains(ele)){
              System.out.print(ele+" ");
        }
      }


  }    
}
