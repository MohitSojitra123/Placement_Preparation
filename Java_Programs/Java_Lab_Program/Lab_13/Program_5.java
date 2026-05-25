// WAP to implement the solution to producer consumer problem in Java. [B]

// Producer Consumer Problem using Thread

class Buffer {

    int data;
    boolean available = false;

    synchronized void produce(int value) {

        while (available) {

            try {
                wait();
            }
            catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        data = value;

        System.out.println("Produced : " + data);

        available = true;

        notify();
    }

    synchronized void consume() {

        while (!available) {

            try {
                wait();
            }
            catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        System.out.println("Consumed : " + data);

        available = false;

        notify();
    }
}

class Producer extends Thread {

    Buffer b;

    public Producer(Buffer b) {
        this.b = b;
    }

    public void run() {

        for (int i = 1; i <= 5; i++) {

            b.produce(i);

            try {
                Thread.sleep(500);
            }
            catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}


class Consumer extends Thread {

    Buffer b;

    public Consumer(Buffer b) {
        this.b = b;
    }

    public void run() {

        for (int i = 1; i <= 5; i++) {

            b.consume();

            try {
                Thread.sleep(500);
            }
            catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}


public class Program_5 {

    public static void main(String[] args) {

        Buffer b = new Buffer();

        Producer p = new Producer(b);

        Consumer c = new Consumer(b);

        p.start();

        c.start();
    }
}