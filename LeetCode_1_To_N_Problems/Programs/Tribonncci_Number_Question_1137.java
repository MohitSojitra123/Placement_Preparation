public class Tribonncci_Number_Question_1137 {

      public int tribonacci(int n) {
       if(n==0){
        return 0;
       }else if(n==1 || n==2){
        return  1;
       }else{
          int a=0,b=1,c=1,d=0;
        for(int i=3; i<=n; i++){
           d=a+b+c;
           a=b;
           b=c;
           c=d;    
        }
        return c;
       }   
    }

    public static void main(String[] args) {
    
         int a=0,b=1,c=1,d=0;

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        for(int i=3; i<=10; i++){
            d=a+b+c;
            System.out.println(d);
            a=b;
            b=c;
            c=d;
        }


   }   
}
