class stu{
      static int number_obj=0;

    public stu(){
        number_obj++;
      }

}

public class Count_Creating_Object {
    public static void main(String[] args) {
     
        stu s1=new stu();
        stu s2=new stu();
        stu s3=new stu();
        stu s4=new stu();
        stu s5=new stu();
        
        System.out.println(s1.number_obj);

    }
}
