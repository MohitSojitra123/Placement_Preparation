// WAP to find a total odd and total even digit of a given number. 


public class Problem_8 {
   public static void main(String[] args) {
    
      int num=5412389;

     int  odd_num=0,even_num=0;

     while (num!=0) {
          if((num%10)%2!=0){
            odd_num++;
          }else{
            even_num++;
          }

          num/=10;
     }

     System.out.println("Odd Number : "+odd_num);
     System.out.println("Even  Number : "+even_num);

   }    
}
