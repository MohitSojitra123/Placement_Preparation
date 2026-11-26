// Write a Java program to find the angle between the hour and minute hands.

class angle{
        angle(int h1,int m1){           
             int h=h1;
             int m=m1;
            
               if(h>=12){
                   h=h%12;
               }
               double ans=Math.abs((30*h)-(11/2.0)*m);
               if(ans>180){
                ans=360-ans;
               }
               System.out.println("Angle => "+ans);
        }
}

public class Program_2 {
    public static void main(String[] args) {
         angle an=new angle(6,18);
    }
}
