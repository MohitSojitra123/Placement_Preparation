interface in1{
     int a=10;
    void show1();
}

class A implements in1{
   public void show1(){
    System.out.println("Hello !! "+in1.a);
   }
}


class Extra_1{
    public static void main(String[] args) {
            A a1=new A();
            a1.show1();
    }
}