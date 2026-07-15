// WAP to find a factorial of a given integer (iterative and recursive)

public class Problem_4_1 {
    public static void main(String[] args) {
        
          int num=5;

          int factor=1;

          for(int i=1; i<=num; i++){
            factor*=i;
          }

          System.out.println(factor);

    }
}
