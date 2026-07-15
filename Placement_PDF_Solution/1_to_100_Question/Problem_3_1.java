// WAP to find a Factor of a given number (iterative and recursive) 

public class Problem_3_1 {
    public static void main(String[] args) {
        
          int num=15;

          System.out.println(num + " Factor : ");

          for(int i=1; i<=num; i++){
            if(num%i==0){
                System.out.println(i);
            }
          }

    }
}
