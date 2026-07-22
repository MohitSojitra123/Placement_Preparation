// WAP  to  check  weather  number  is  present  in  array  or  not  (using  recursion  only)  and  the 
// function’s syntax is given below 
// Int isInArray(int a[],int m);  
// Where int a[] is Array of integer and m is element to be searched.

public class Problem_25 {

    static int  current_index=0;

      int isInArray(int arr[],int m){

          if(current_index==arr.length) {
            return -1;
          }else if(arr[current_index]==m){
            return current_index;
          } 

          current_index++;
          return isInArray(arr, m);

      }
   public static void main(String[] args) {
    
    
    Problem_25 pb=new Problem_25();
    
    
       int array[]={10,20,30,40,50,60};

       System.out.println(pb.isInArray(array, 50));

   }    
}
