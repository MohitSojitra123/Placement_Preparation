// Create interface EventListener with performEvent() method. Create MouseListener
// interface which inherits EventListener along with mouseClicked(), mousePressed(),
// mouseReleased(), mouseMoved(), mouseDragged() methods. Also create KeyListener
// interface which inherits EventListener along with keyPressed(), keyReleased() methods.
// WAP to create EventDemo class which implements MouseListener and KeyListener and
// demonstrate all the methods of the interfaces. [A]


interface EventListener {
    void performEvent();
}

interface MouseListener extends EventListener {
    void mouseClicked();
    void mousePressed();
    void mouseReleased();
    void mouseMoved();
    void mouseDragged();
}

interface KeyListener extends EventListener {
    void keyPressed();
    void keyReleased();
}

class EventDemo implements MouseListener, KeyListener  {

    @Override
    public void performEvent() {
        System.out.println("All Event Perform !! ");
    }

    @Override
    public void mouseClicked() {
        System.out.println("Mouse clicked event.");
    }

    @Override
    public void mousePressed() {
        System.out.println("Mouse pressed event.");
    }

    @Override
    public void mouseReleased() {
        System.out.println("Mouse released event.");
    }

    @Override
    public void mouseMoved() {
        System.out.println("Mouse moved event.");
    }

    @Override
    public void mouseDragged() {
        System.out.println("Mouse dragged event.");
    }

    @Override
    public void keyPressed() {
        System.out.println("Key pressed event.");
    }

    @Override
    public void keyReleased() {
        System.out.println("Key released event.");
    }
}

public class Program_2 {
    public static void main(String[] args) {
        EventDemo demo = new EventDemo();

        demo.performEvent();
        System.out.println();

        demo.mouseClicked();
        demo.mousePressed();
        demo.mouseReleased();
        demo.mouseMoved();
        demo.mouseDragged();
        System.out.println();

        demo.keyPressed();
        demo.keyReleased();
    }
}

