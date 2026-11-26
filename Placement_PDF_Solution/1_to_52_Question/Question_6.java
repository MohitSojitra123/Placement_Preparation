// 6 Write a program to check whether number is Happy number or not.  
// A  happy  number  are those number whose digit’s square summation eventually reaches to 1, if the 
// sequence start repeating then it is not a happy number.   
// E.g., 49 is a happy number whose sequence is 49 97 130 10 1. 
// E.g., 50 is not a happy number whose sequence is 50 25 29 85 89 145 42 20 4 16 37 58 89 it should stop 
// when 89 is detected 2nd time and print 50 is not a happy number. 

import java.util.HashSet;
import java.util.Scanner;

public class Question_6 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Any Number To Check Number Is Happy Or Not : ");
        int num=sc.nextInt();

        HashSet hs=new HashSet<>();

        int sum=0;
        boolean flag=true;

        while (true) {
            sum=0;
            while (num!=0) {
                int temp=num%10;
                sum+=temp*temp;
                num/=10;
            }

            
            if(sum==1){
                System.out.println("Number Is Happy : ");
                break;
            }else{
                if(hs.contains(sum)){
                    flag=false;
                    break;
                }else{
                    hs.add(sum);
                }
            }
            num=sum;
            
        }

        if(!flag){
            System.out.println("Number Is Not Happy : ");
        }
    }
}
