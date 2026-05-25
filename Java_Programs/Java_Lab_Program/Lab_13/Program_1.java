// Write a java Multithread program [A]
// i. Using Thread class.
// ii. Using Runnable Interface.

class MyThread extends Thread{
    public void run(){
        for(int i=1; i<=10; i++){
            System.out.println("Thread Class Used :  "+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
               System.out.println(e);
            }
        }
        }
}

public class Program_1 {
    public static void main(String[] args) {
        
          MyThread th1=new MyThread();
          MyThread th2=new MyThread();

            th1.start();
            th2.start();
    }
}