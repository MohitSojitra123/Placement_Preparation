// WAP that counts the number of objects created using static. [A]

class obj_class{

      static int count=0;

    obj_class(){
        System.out.println("Object Created....");
        count++;
    }
}

public class program_2 {
  public static void main(String[] args) {
    
       obj_class obj1=new obj_class();
       obj_class obj2=new obj_class();
       System.out.println("-----------------------");
       System.out.println(obj_class.count);
       System.out.println("-----------------------");
       obj_class obj3=new obj_class();
       obj_class obj4=new obj_class();
       obj_class obj5=new obj_class();
        System.out.println("-----------------------");
       System.out.println(obj_class.count);
       System.out.println("-----------------------");

  }    
}
