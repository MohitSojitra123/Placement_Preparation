// 21 Given a string and write a C program to count the number of vowels and consonants 
// in this string.   
// Input: str = "geeks for geeks" 
// Output: 
// Vowels: 5 
// Consonants: 8  
// Input: str = "abcdefghijklmnopqrstuvwxyz" 
// Output: 
// Vowels: 5 
// Consonants: 21

public class Problem_21 {
   public static void main(String[] args) {
    
    //    String str="abcdefghijklmnopqrstuvwxyz";
            String str="geeks for geeks";

       int Vowel=0;
       int Consonants=0;

       for(int i=0; i<str.length(); i++){
         char ch=str.charAt(i);   
        if(Character.isLetter(ch)){
               if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                 Vowel++;
               }else{
                  Consonants++; 
               }
           }
       }
       System.out.println("Vowel : "+Vowel);
       System.out.println("Consonants : "+Consonants);
   }
}