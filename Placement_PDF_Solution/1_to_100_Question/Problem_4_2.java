// WAP to find a factorial of a given integer (iterative and recursive)


public class Problem_4_2 {

    int factorial(int num){
       if(num<=0){
        return 1;
       }

       return num*factorial(num-1);
    }

    public static void main(String[] args) {

         int num=6;
        
         Problem_4_2 pb=new Problem_4_2();

         System.out.println(pb.factorial(num));

    }
}
