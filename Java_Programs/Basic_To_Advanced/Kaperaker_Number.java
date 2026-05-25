import java.util.Scanner;

class Kaperaker_Number{
      public static void main(String[] args) {
        
           Scanner sc=new Scanner(System.in);

           int user_num;

           System.out.println("Enter Number : ");
           user_num=sc.nextInt();

           int squre=user_num*user_num;

           int temp=user_num;

           int digit_count=0;

           while (temp!=0) {
               digit_count++;
               temp/=10;
           }

           int Compare_Sum=0;

           String str_num=Integer.toString(squre);

           for(int i=0; i<str_num.length(); i+=digit_count){
                     if(i+digit_count<str_num.length()){
                            Compare_Sum+=Integer.parseInt((str_num.substring(i, i+digit_count)));
                     }else{
                          Compare_Sum+=Integer.parseInt(str_num.substring(i));
                     }
           }


           System.out.println("Squre : "+squre);
           System.out.println("Compare Sum : "+Compare_Sum);


           if(Compare_Sum==user_num){
            System.out.println("Number Is Kaperaker : ");
           }else{
            System.out.println("Number Is Not Kaperaker : ");
           }

      }
}