import java.util.Scanner;

public class Bottel_Exchange_Problem_Question_1518 {
    public static void main(String[] args) {
          
        Scanner sc=new Scanner(System.in);

          int numBottles,numExchange;

          System.out.println("Enter Number Of Bottles : ");
          numBottles=sc.nextInt();

          System.out.println("Enter Number Of Exchange Bottles : ");
          numExchange=sc.nextInt();

          int FinalBottles=numBottles;

          while(numBottles>=numExchange){
              int newBottle=numBottles/numExchange;
              int remBottle=numBottles%numExchange;

              FinalBottles+=newBottle;

              numBottles=newBottle+remBottle;
          }

          System.out.println("Final Drink Bottles Is : "+FinalBottles);


    }
}
