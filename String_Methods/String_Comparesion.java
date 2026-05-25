public class String_Comparesion {
    public static void main(String[] args) {
        
           String s1="Hello";
           String s2="Hello";

           System.out.println(s1==s2); //true

           String s3=new String("Hello");
           String s4=new String("Hello");

           System.out.println(s3==s4);  //false

           System.out.println(s1==s3);  //false  

           System.out.println(s1.equals(s3));  //true

           System.out.println(s1.equals(s2));  //true

    }
}
