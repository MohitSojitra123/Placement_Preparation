// Given a string that contains both upper and lower case characters in it. The task is to 
// count a number of upper and lower case characters in it.  
// Input: Introduction to Python 
// Output: Lower Case characters : 18  
//                 Upper case characters : 2 
// Input:  Welcome to GeeksforGeeks 
// Output: Lower Case characters : 19   
//                 Upper case characters: 3

class Problem_26{
      public static void main(String[] args){
        
        int UpperCase=0;
        int LowerCase=0;
           

        String str="Introduction to Python";

        for(int i=0; i<str.length(); i++){
               if(str.charAt(i) >='a' && str.charAt(i)<='z'){
                  LowerCase++;
               }else if (str.charAt(i) >='A' && str.charAt(i)<='Z') {
                     UpperCase++;
               }
        }

        System.out.println("UpperCase : "+UpperCase);
        System.out.println("LowerCase : "+LowerCase);

      }
}