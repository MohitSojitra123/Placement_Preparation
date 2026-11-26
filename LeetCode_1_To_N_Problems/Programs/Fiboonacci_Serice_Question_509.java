class Fiboonacci_Serice_Question_509{
    
     public int fib(int n) {

        if(n == 0) return 0;
        if(n == 1) return 1;

        int a = 0;
        int b = 1;
        int c = 0;

        for(int i = 2; i <= n; i++){
            c = a + b;
            a = b;
            b = c;
        }

        return b;
    }
    
    public static void main(String[] args) {
        
        int a=0,b=1,c=0;
       
        for(int i=1; i<=10; i++){
             System.out.println(c);
             c=a+b;
             a=b;
             b=c;
        }

       
    }
}