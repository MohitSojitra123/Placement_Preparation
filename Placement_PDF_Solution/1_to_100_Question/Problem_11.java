// WAP to find weather given number is Armstrong number is not.

public class Problem_11 {
    public static void main(String[] args) {
        

        int num=153;
        // int num=9474;
        int temp=num;
        int num_length=0;
       int Armstrong_num=0;


        while (temp!=0) {
              num_length++;
              temp/=10;
        }

        temp=num;

        while (temp!=0) {
               int last_digit=temp%10;
               Armstrong_num+=Math.pow(last_digit, num_length);
               temp/=10;
        }

        if(Armstrong_num==num){
            System.out.println("Number Is Armstrong Number : ");
        }else{
            System.out.println("Number Is Not a Armstrong : ");
        }


    }
}
