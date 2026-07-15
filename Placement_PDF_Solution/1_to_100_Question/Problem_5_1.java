// WAP to find a summation of a digit of a given number. (Iterative and recursive) 

public class Problem_5_1 {
    public static void main(String[] args) {
        
           int num=4532;

           int sum=0;

           while (num!=0) {
               sum+=num%10;
               num/=10;
           }

           System.out.println(sum);


    }
}
