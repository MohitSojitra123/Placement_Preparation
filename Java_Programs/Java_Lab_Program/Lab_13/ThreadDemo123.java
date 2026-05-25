class MyThread123 extends Thread {
    public void run() {
        // Child thread prints numbers 1 to 10
        for (int i = 1; i <= 10; i++) {
            // System.out.println("Child Thread : " + i);
            System.out.println(" 4  * "  + i + " =  " + (4*i));
            try {
                Thread.sleep(500); // making thread wait for 0.5 sec
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class ThreadDemo123 {
    public static void main(String[] args) {
        MyThread123 t = new MyThread123(); 
        t.start();                   

        for (int i = 1; i <= 10; i++) {
            System.out.println("Main Thread : " + i);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

