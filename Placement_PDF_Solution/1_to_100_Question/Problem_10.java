// WAP to find a prime number between range (range should be entered by user).

public class Problem_10 {

      
    static boolean isPrime(int num){
          for(int i=2; i<num; i++){
            if(num%i==0){
                return false;
            }
          }
          return true;
    }

    public static void main(String[] args) {
        
        int start=10;
        int end=50;

        for(int i=start; i<=end; i++){

            if(Problem_10.isPrime(i)){
                System.out.print(i+" ");
            }

        }

    }
    
}