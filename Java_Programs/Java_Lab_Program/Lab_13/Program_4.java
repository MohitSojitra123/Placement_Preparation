// Write a program to create two threads, one thread will print odd numbers and second
// thread will print even numbers between 1 to 20 numbers. [A]


class OddThread implements Runnable{
    public void run(){
        try{
            for(int i=1; i<=20; i++){
                 if(i%2 != 0){
                   System.out.println("Odd Thread : "+i);
                 }
                 Thread.sleep(1000);
            }
        }catch(InterruptedException e){
            System.out.println(e);
        }
    }
}

class EvenThread implements Runnable{
      public void run(){
        try{
            for(int i=1; i<=20; i++){
                if(i%2==0){
                    System.out.println("Even Thread : "+i);
                }
                Thread.sleep(2000);
            }
        }catch(InterruptedException e){
            System.out.println(e);
        }
      }
}


public class Program_4 {
    public static void main(String[] args) {
        
        // OddThread odd1=new OddThread();
        // EvenThread even1=new EvenThread();

        // Thread t1=new Thread(odd1);
        // Thread t2=new Thread(even1);

        // t1.start();
        // t2.start();

       Thread t1=new Thread(new OddThread());
       Thread t2=new Thread(new EvenThread());

        t1.start();
        t2.start();

    }
}
