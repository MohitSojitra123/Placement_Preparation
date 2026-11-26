class Palindrom_Number_Question_9{

        boolean isPalindrom(int x){
              if(x<0){
                   return false;
              }else{
                 int n=x;
                 int reverse=0;
                 while(n!=0){
                   reverse=(reverse*10)+n%10;
                   n/=10; 
                 }
                 if(reverse==x){
                    return true;
                 }else{
                    return false;
                 }
              }
        }
    public static void main(String[] args) {
        
     Palindrom_Number_Question_9 q9=new Palindrom_Number_Question_9();

     System.out.println(q9.isPalindrom(102));

        
    }
}