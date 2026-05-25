import java.util.Scanner;

public class Count_All_Palindrom_String_in_The_Word {

    static  boolean  Check_Palindrom_String(String check){
           int i=0; 
           int j=check.length()-1;

           while (i<j) {
              if(check.charAt(i) != check.charAt(j)){
                  return false;
                } 
                j--;
                i++;
           }
           return true;
    }

   public static void main(String[] args) {
      
       Scanner sc=new Scanner(System.in);

       System.out.println("Enter String : ");
       String str=sc.nextLine();

       String Temp="";
       int count=0;

       for(int i=0; i<str.length(); i++){
          for(int j=i+1; j<=str.length(); j++){
            Temp  = str.substring(i, j); 
            if(Count_All_Palindrom_String_in_The_Word.Check_Palindrom_String(Temp)){
                System.out.println(Temp);
                count++;
            }
            Temp="";
          }    
       }
        

       System.out.println("\n\n");
       System.out.println("Total SubString : "+count);
       System.out.println("\n\n");


   }    
}
