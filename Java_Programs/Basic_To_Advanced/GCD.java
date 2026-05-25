import java.util.Scanner;

public class GCD {
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int a,b;

        System.out.println("Enter A : ");
        a=sc.nextInt();

        System.out.println("Enter B : ");
        b=sc.nextInt();

        int max,min;

        if(a>b){
            max=a;
            min=b;
        }else{
            max=b;
            min=a;
        }

        int GCD=0;

        for(int i=1; i<=min; i++){
          if(max%i==0 && min%i==0){
            GCD=i;
          }
        }

        System.out.println("GCD : "+GCD);


    }

}
