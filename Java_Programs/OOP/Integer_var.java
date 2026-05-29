public class Integer_var {

     public static void swap(Integer a,Integer b){
             Integer Temp=a;
             a=b;
             b=Temp;
      }
    public static void main(String[] args) {
        
          Integer a=10;
          Integer b=20;

          System.out.println("  a  =  "+a+"  b = "+b);
          
          swap(a, b);
          
          System.out.println("  a  =  "+a+"  b = "+b);

        }
}
