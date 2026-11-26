// WAP That FInds an angle between clock hands for the provided value of minutes and hours
// E..G.. if hours = 12 and minutes=30 then angle between them is 165 

import java.util.Scanner;

public class Angle_Between {
    public static void main(String[] args) {
           Scanner sc = new Scanner(System.in);
        

        System.out.print("Enter hours (1 to 12): ");
        int hours = sc.nextInt();
        
        System.out.print("Enter minutes (0 to 59): ");
        int minutes = sc.nextInt();

        
        hours = hours % 12;
        
        // Calculate angles
        double hourAngle = (hours * 30) + (minutes * 0.5); // Each hour = 30°, each minute = 0.5° shift of hour hand
        double minuteAngle = minutes * 6; // Each minute = 6°
        
        // Find the difference
        double angle = Math.abs(hourAngle - minuteAngle);
        
        // Minimum angle between them
        angle = Math.min(angle, 360 - angle);
        
        System.out.println("Angle between hour and minute hand = " + angle + " degrees");
    }
}
