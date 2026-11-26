// WAP to calculate an angle between hour and minute hand. (Hours and minutes should be 
// taken from user).

import java.util.Scanner;

public class Problem_14 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Hour (0-12): ");
        int hour = sc.nextInt();

        System.out.print("Enter Minute (0-59): ");
        int minute = sc.nextInt();


        if (hour < 0 || hour > 12 || minute < 0 || minute > 59) {
            System.out.println("Invalid Time!");
            return;
        }


        if (hour == 12) {
            hour = 0;
        }


        double hourAngle = (hour * 30) + (minute * 0.5);
        double minuteAngle = minute * 6;

        double angle = Math.abs(hourAngle - minuteAngle);

        if (angle > 180) {
            angle = 360 - angle;
        }

        System.out.println("Angle between Hour and Minute hand = " + angle + " degrees");

        sc.close();
    }
}