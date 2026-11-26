import java.util.*;

// WAP that finds an angle between clock hands for the provided value of Minutes and Hours. 


public class Question_7 {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        

        System.out.print("Enter hours  ");
        int hours = sc.nextInt();
        
        System.out.print("Enter minutes  ");
        int minutes = sc.nextInt();
        
        hours = hours % 12;
        
        double hourAngle = (hours * 30) + (minutes * 0.5); 
        double minuteAngle = minutes * 6; 
        
        double angle = Math.abs(hourAngle - minuteAngle);
        
        angle = Math.min(angle, 360 - angle);
        
        System.out.println("Angle between hour and minute hand = " + angle + " degrees");
    }
}


