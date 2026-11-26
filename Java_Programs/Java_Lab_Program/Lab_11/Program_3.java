// The Transport interface declares a deliver () method. The abstract class Animal is the
// super class of the Tiger, Camel, Deer and Donkey classes. The Transport interface is
// implemented by the Camel and Donkey classes. Write a test program that initialize an
// array of four Animal objects. If the object implements the Transport interface, the
// deliver () method is invoked. [B]

interface Transport {
    void deliver();
}

abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void sound();
}

class Tiger extends Animal {
    public Tiger(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.println(name + " says: Roar!");
    }
}


class Deer extends Animal {
    public Deer(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.println(name + " says: Bleat!");
    }
}


class Camel extends Animal implements Transport {
    public Camel(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.println(name + " says: Grunt!");
    }

    @Override
    public void deliver() {
        System.out.println(name + " is delivering goods using Transport.");
    }
}


class Donkey extends Animal implements Transport {
    public Donkey(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.println(name + " says: Hee-haw!");
    }

    @Override
    public void deliver() {
        System.out.println(name + " is delivering goods using Transport.");
    }
}

public class Program_3 {
    public static void main(String[] args) {

 
        Tiger t1=new Tiger("Tiger");
        Deer d1=new Deer("Deer");

        t1.sound();
        System.out.println("------------------------");
        d1.sound();
        System.out.println("------------------------");
        
        Camel c1=new Camel("Camel");
        Donkey do1=new Donkey("Donkey");
        
        c1.sound();
        System.out.println("------------------------");
        c1.deliver();
        System.out.println("------------------------");
        
        do1.sound();
        System.out.println("------------------------");
        do1.deliver();
        System.out.println("------------------------");

    }
}
