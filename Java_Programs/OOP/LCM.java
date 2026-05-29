public class LCM {
    
    public static int calculate_lcm(int a,int b){
         int min=Math.min(a, b);

         int lcm=0;

         for(int i=min; i>=1; i--){
            if(a%i==0 && b%i==0){
                  return i;
            }
         }

         return 0;
    }
    
    public static void main(String[] args) {
        

        System.out.println(LCM.calculate_lcm(28, 7));



    }
}
