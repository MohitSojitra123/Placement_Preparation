// Create class Cube with attributes (height, width and depth with double datatype).
// Implement getter() and setter() method to assign data for 2 cubes. Create method
// volume() to calculate volume for 2 cubes. 

class Cube{

      double height,width,depth;

    public void setter(double height,double width,double  depth){
         this.height=height;
         this.width=width;
         this.depth=depth;        
    }

    public void getter(){
        System.out.println("Cube => "+(height*width*depth));
    }

    public double volume(){
           return (height+width+depth);
    }    
}


public class Program_2{
   public static void main(String[] args) {

      Cube c1=new Cube();
      Cube c2=new Cube();
      Cube c3=new Cube();


      c1.setter(23.54,34.43,34.76);
      c1.getter();

    c2.setter(23.54,34.43,34.76);
    c2.getter();

    c3.setter(23.43,34.23,52.3);
    System.out.println("Cube In Volume => "+c3.volume());




   }   
}
