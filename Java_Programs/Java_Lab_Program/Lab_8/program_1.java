// Define Time class with constructor to initialize hour and minute. Also define addition
// method to add two time objects. [A]

class time_cal{
       int h;
       int m;

      time_cal(int h,int m){
              this.h=h;
              this.m=m;
      }

      time_cal calculate(time_cal t){
          int h1=0,m1=0;

          m1=this.m+t.m;
          h1=this.h+t.h;

          while(m1>60){
               m1=m1%60;
               h1++; 
          }
          return new time_cal(h1, m1);
     }
}


public class program_1{
     public static void main(String[] args) {
        
          time_cal t1=new time_cal(3, 66);
          time_cal t2=new time_cal(1, 60);

          time_cal t3=t1.calculate(t2);

          System.out.println("-------------------------------");
          System.out.println("Hours => "+t3.h);
          System.out.println("Minute => "+t3.m);
          System.out.println("-------------------------------");

     }
}