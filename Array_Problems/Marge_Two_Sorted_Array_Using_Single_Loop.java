import java.util.Arrays;
import java.util.Scanner;

class Marge_Two_Sorted_Array_Using_Single_Loop{
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);


        int arr1[]={2,3,6,7,9,9};
        int arr2[]={1,4,8,10,12,15,19,22,39};

        int sorted_array[]=new int[arr1.length+arr2.length];

        int i=0;
        int j=0;
        int current_index=0;

     
        while (i<arr1.length || j<arr2.length) {
            
               if(i<arr1.length && j<arr2.length){
                   if(arr1[i]<arr2[j]){
                        sorted_array[current_index]=arr1[i];
                        i++;
                    }else{
                        sorted_array[current_index]=arr2[j];
                        j++;
                    }
                    current_index++;
                }else if(i<arr1.length){
                    sorted_array[current_index]=arr1[i];
                    i++;
                    current_index++;
               }else   if(j<arr2.length){
                      sorted_array[current_index]=arr2[j];
                      j++;  
                      current_index++;
               }

        } 

        System.out.println(Arrays.toString(sorted_array));

        
    }
}

