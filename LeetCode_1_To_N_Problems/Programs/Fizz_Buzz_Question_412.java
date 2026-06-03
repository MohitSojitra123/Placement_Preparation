import java.util.ArrayList;
import java.util.List;

public class Fizz_Buzz_Question_412 {
    public static void main(String[] args) {
        
         int n=5;

        List<String> result=new ArrayList<>();

       for(int i=1; i<=n; i++){

         if(i%3==0 && i%5==0){
            result.add("FizzBuzz");
         }else if(i%3==0){
            result.add("Fizz");
         }else if(i%5==0){
            result.add("Buzz");
         }else{
            result.add(Integer.toString(i));
         }    
       }

       for(String str:result){
        System.out.print(str+" ");
       }
         

    }
}
