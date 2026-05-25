import java.util.Scanner;

public class Perfect_Number {
    public static void main(String[] args) {
           Scanner sc=new Scanner(System.in);

        System.out.println("Enter Any Number To Check Number Is Perfect Or Not....");
        int user_number=sc.nextInt();

        int final_count=0;

        for(int i=1; i<user_number; i++){
             if(user_number%i==0){
                   final_count+=i;
                }
        }

        if(final_count==user_number){
            System.out.println("Number Is Perfect "+user_number);
        }else{
            System.out.println("Number Is Not  Perfect "+user_number);
        }

    }
}
