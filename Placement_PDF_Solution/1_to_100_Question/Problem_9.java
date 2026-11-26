// WAP to find whether a number is Odd or Even without using a % operator. 

public class Problem_9 {
    public static void main(String[] args) {
        
           int num=21;

        //    if((num/2)*2==num){
           if((num & 1)==0){
            System.out.println("Number Is Even : ");
           }else{
            System.out.println("Number Is Odd : ");
           }

    }
}
