// Write an application that executes two threads. One thread displays "Good Morning"
// every 1000 milliseconds & another thread displays "Good Afternoon" every 3000
// milliseconds. Create the threads by implementing the Runnable interface. [A]

class GoodMoring implements Runnable{
    public void run(){
        try{
              for(int i=1; i<=10; i++){
                    System.out.println("Good Morning "+i);
                    Thread.sleep(1000);
              }
        }catch(InterruptedException e){
            System.out.println(e);
        }
    }
}

class GoodAfternoon implements Runnable{
    public void run(){
        try{
            for(int i=1; i<=10; i++){
               System.out.println("Good Afternoon "+i);
               Thread.sleep(3000);
            }
        }catch(InterruptedException e){
                System.out.println(e);
            }
        }
    }


public class Program_3 {
    public static void main(String[] args) {
        
    // GoodMoring g1=new GoodMoring();    
    // GoodAfternoon g2=new GoodAfternoon();
     

    // Thread t1=new Thread(g1);
    // Thread t2=new Thread(g2);

    // t1.start();
    // t2.start();

    Thread t1=new Thread(new GoodMoring());
    Thread t2=new Thread(new GoodAfternoon());

    t1.start();
    t2.start();

    }
}
