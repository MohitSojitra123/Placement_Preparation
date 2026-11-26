// Write a program that illustrates interface inheritance. Interface A is extended by A1 and
// A2. Interface A12 inherits from both A1 and A2.Each interface declares one constant
// and one method. Class B implements A12.Instantiate B and invoke each of its methods.
// Each method displays one of the constants. [A]

interface A {
    int A = 10; 
    void methodA();      
}

interface A1 extends A {
    int A1 = 20;
    void methodA1();
}

interface A2 extends A {
    int A2 = 30;
    void methodA2();
}

interface A12 extends A1, A2 {
    int A12 = 40;
    void methodA12();
}

class B implements A12 {

     int A2=100;

    @Override
    public void methodA() {
        System.out.println("MethodA called. CONSTANT_A = " + A);
    }

    @Override
    public void methodA1() {
        System.out.println("MethodA1 called. CONSTANT_A1 = " + this.A1);
    }

    @Override
    public void methodA2() {
        System.out.println("MethodA2 called. CONSTANT_A2 = " + this.A2);
    }

    @Override
    public void methodA12() {
        System.out.println("MethodA12 called. CONSTANT_A12 = " + A12);
    }
}


public class Program_1 {
    public static void main(String[] args) {
        B obj = new B();

        obj.methodA();
        obj.methodA1();
        obj.methodA2();
        obj.methodA12();
    }
}
