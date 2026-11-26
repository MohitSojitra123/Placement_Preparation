// Define class for Complex number with real and imaginary as data members. Create its
// constructor, overload the constructors. Also define addition method to add two
// complex objects.


class real_img{

     int real,img;

     real_img(){
          this.real=0;
          this.img=0;
     }

     real_img(int real){
         this.real=real;
         this.img=0;
     }

      real_img(int real,int img){
              this.real=real;
              this.img=img; 
      }

     void display(){
        System.out.println("Real... => "+this.real);
        System.out.println("Img... => "+this.img);
     }  

      void add(real_img ri){
       this.real=this.real+ri.real;
       this.img=this.img+ri.img;
        System.out.println("Real => "+this.real+" Img => "+this.img);
      }

}

public class Program_4 {
      public static void main(String[] args) {
        
          real_img ri1=new real_img();
          ri1.display();
         System.out.println("-------------------------------");
         real_img ri2=new real_img(10);
         ri2.display();
         System.out.println("-------------------------------");
         real_img ri3=new real_img(10,20);
         real_img ri4=new real_img(10,20);
         ri3.add(ri4);
         System.out.println("-------------------------------");



      }
}
