import java.util.Scanner;

public class Strong_Number1 {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Any Number To Ckeck Number Is Strong Or Not ;: ");
        int num=sc.nextInt();

        int compare_number=0;
        int num2=num;

        while (num!=0) {
            int last_digit=num%10;
            compare_number+=find_factor(last_digit);
            num/=10;
        }

        if(compare_number==num2){
            System.out.println("Strong Number : ");
        }else{
            System.out.println("Not a Strong Number : ");
        }

    }

    public static int find_factor(int n){
        int ans=1;
        for(int i=1; i<=n; i++){
              ans*=i;
        }
        return ans;
    }

}
