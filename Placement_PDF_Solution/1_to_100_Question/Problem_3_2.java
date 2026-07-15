// WAP to find a Factor of a given number (iterative and recursive) 


public class Problem_3_2 {

     static int i=1;

       void factor(int i,int num){
        
           if(i>num){
            return;
           }else{
              if(num%i==0){
                  System.out.println(i);
                }
                  factor(i+1, num);
            }
       }

    public static void main(String[] args) {
        
           int n=30;

           Problem_3_2 pb=new Problem_3_2();

           pb.factor(i, n);

    }
}
