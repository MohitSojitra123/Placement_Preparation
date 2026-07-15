// WAP to find a summation of a digit of a given number. (Iterative and recursive) 

public class Problem_5_2 {
    
       int Digit_Sum(int num){
             if(num==0){
                  return 0;
             }
             return num%10+Digit_Sum(num/=10);
       }

    public static void main(String[] args) {
        

          int num=5462;

          Problem_5_2 pb=new Problem_5_2();

          System.out.println(pb.Digit_Sum(num));

    }

}
