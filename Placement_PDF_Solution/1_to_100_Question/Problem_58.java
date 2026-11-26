// Write a program to check weather number is happy number is not, happy number are those 
// number whose digit’s square summation eventually reaches to 1, if the sequence start 
// repeating then it is not a happy number, to store this sequence, use a dynamic data structure. 
// E.g., 49 is a happy number whose sequence is 49 97 130 10 1 
// E.g., 50 is not a happy number whose sequence is 50 25 29 85 89 145 42 20 4 16 37 58 89 
// it should stop when 89 is detected 2nd time and print 50 is not a happy number.  

import java.util.HashSet;

public class Problem_58 {
    public static void main(String[] args) {
        
        int num=50;

        HashSet<Integer> hs=new HashSet<>();

        boolean ishappy=true;
        
        while (true) {
            int sum=0;

            while (num!=0) {
                int lastDigit=num%10;
                sum+=lastDigit*lastDigit;
                num/=10;
            }

            if(sum==1){
                break;
            }else if (hs.contains(sum)) {
                  ishappy=false;
                 break;
            }else{
              hs.add(sum);
              num=sum;
            }

        }


        if(ishappy){
            System.out.println("Number Is Happpyyy : ");
        }else{
            System.out.println("Number Is Not Happy : ");
        }


    }
}
