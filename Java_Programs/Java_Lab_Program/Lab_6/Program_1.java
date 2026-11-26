// Create class Student with attributes (name: String, roll_no:int, SPI:double,
// course: String). Implement getter() and setter() method to assign data for 3
// students and display it.

class Student{
     
    int roll_no;
    String name;
    double spi;
    String cours;

    public void setter(int roll_no,String name,double spi,String cours){
          this.roll_no=roll_no;
          this.name=name;
          this.spi=spi;
          this.cours=cours;
    }

    public void getter(){
          System.out.println("Roll Number => "+this.roll_no);
          System.out.println("Name => "+this.name);
          System.out.println("SPI => "+this.spi);
          System.out.println("Cours => "+this.cours);
    }
}


class Program_1{
    public static void main(String[] args) {
        
        Student s1=new Student();
        Student s2=new Student();

        s1.setter(101, "Mohit", 7.89, "MCA");
        s2.setter(102, "Rohit", 9.89, "MBA");

        s1.getter();
        s2.getter();

    }
}