// Write a java program that implements a multi-thread application that has
// three threads. First thread generates random integer every 1 second and if
// the value is even, second thread computes the square of the number and
// prints. If the value is odd, the third thread will print the value of cube of
// the number. [B]

import java.util.Random;

class Squre implements Runnable{
     int num;

    Squre(int num){
       this.num=num;
    }
    
    public void run(){
         try{
             System.out.println("Squre : "+(num*num));
         }catch(Exception e){
            System.out.println(e);
         }
      }
}

class Cube implements Runnable{
      int num;

         Cube(int num){
       this.num=num;
    }
    
    public void run(){
         try{
             System.out.println("Cube : "+(num*num*num));
         }catch(Exception e){
            System.out.println(e);
         }
      }
}

public class Program_6 {
    public static void main(String[] args) {
        
        for(int i=1; i<=10; i++){
            int r1= (int)(Math.random() * 100);
        
        
        Squre sq1=new Squre(r1);
        Cube cube1=new Cube(r1);
        
        Thread t1=new Thread(sq1);
        Thread t2=new Thread(cube1);

         if(r1%2 == 0 ){
            t1.start();
         }else{
            t2.start();
         }

         try{
                t1.sleep(2000);
         }catch(InterruptedException e){
            System.out.println(e);
         }

        }
        
    }
}
