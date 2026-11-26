// 22 Given a number N, the task is to print the prime numbers from 1 to N. 
// Input: N = 10 
// Output: 2, 3, 5, 7  
// Input: N = 5 
// Output: 2, 3, 5 

public class Problem_22 {
  
     public static boolean IsPrime(int num){
           for(int i=2; i<num; i++){
              if(num%i==0){
                   return false;
              }
           }
           return true;
     }

    public static void main(String[] args) {
    

        int n=10;

        for(int i=2; i<=10; i++){
            if(IsPrime(i)){
                System.out.println(i);
            }
        }
        

  }    
}
