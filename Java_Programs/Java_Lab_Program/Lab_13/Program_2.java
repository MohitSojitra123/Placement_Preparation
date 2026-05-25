class MyRunnble implements Runnable{
     public void run(){
       try {
        for(int i=1; i<=10; i++){
             System.out.println("Runnable Thread "+i);
                Thread.sleep(1000);
        }} catch (InterruptedException e) {
                e.printStackTrace();
            } 
     }
}

public class Program_2 {
    public static void main(String[] args) {
        
        MyRunnble my1=new MyRunnble();

        Thread t1=new Thread(my1);
        Thread t2=new Thread(my1);
        

       t1.start();
       t2.start();
          
    

    }
}
