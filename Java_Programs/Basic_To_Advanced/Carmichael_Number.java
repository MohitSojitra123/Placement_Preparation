import java.util.Scanner;

public class Carmichael_Number {

      static boolean Check_Prime(int num){
        
           for(int i=2; i<num; i++){
              if(num%i==0){
                  return false;
              }
           }
           return true;
      }

    public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);
          
          System.out.println("Enter Any Number To Check Number Is Caemichael Number ? ");
          int user_num=sc.nextInt();

          if(Carmichael_Number.Check_Prime(user_num)){
            System.out.println("Number Is Not Carmichael Number : ");
            return ;
          }

          int temp=user_num;
          boolean flag=true;


          for(int i=2; i<=temp; i++){
            
            if(temp%i==0){
                
                 int count=0;

                 while (temp%i==0) {
                       count++;
                       temp/=i;
                 }

                 if(count>1){
                    flag=false;
                    break;
                 }

                 if((user_num-1) % (i-1)!=0){
                            flag = false;
                            break;
                 }
            }

          }

          if(flag){
            System.out.println("Number Is Carmichael Number : ");
          }else{
            System.out.println("Number Is Not Carmicael Number : ");
          }



    }
}
