// Write a Java program to create an interface Playable with a method play() that takes no
// arguments and returns void. Create three classes Football, Volleyball, and Basketball
// that implement the Playable interface and override the play() method to play the
// respective sports. [C]

interface Playable {
    void play();  
}

class Football implements Playable {
    public void play() {
        System.out.println("Playing Football!");
    }
}

class Volleyball implements Playable {
    public void play() {
        System.out.println("Playing Volleyball!");
    }
}

class Basketball implements Playable {
    public void play() {
        System.out.println("Playing Basketball!");
    }
}

// Test class
public class Program_5 {
    public static void main(String[] args) {
        Playable football = new Football();
        Playable volleyball = new Volleyball();
        Playable basketball = new Basketball();

        football.play();
        volleyball.play();
        basketball.play();
    }
}
