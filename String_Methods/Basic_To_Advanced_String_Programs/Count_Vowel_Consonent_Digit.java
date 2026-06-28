package Basic_To_Advanced_String_Peograms;
// Count vowels in a string
// Count consonants in a string
// Count digits in a string

public class Count_Vowel_Consonent_Digit {
    public static void main(String[] args) {
    
          String str="sdv234bgtr234t ga sedi co2uu3 n4t";

          str=str.toLowerCase();

          int Digit_Count=0;
          int Consonants_Count=0;
          int Vowels_Count=0;
          int Space_Count=0;

          char ch[]=str.toCharArray();

          for(int i=0; i<ch.length; i++){
               if(Character.isDigit(ch[i])){
                    Digit_Count++;
               }

               if(ch[i]==' '){
                Space_Count++;
               }
               
               if(ch[i]>='a' && ch[i]<='z'){
                   if(ch[i] =='a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u'){
                       Vowels_Count++;
                }else{
                    Consonants_Count++;
                }
            }
          }

          System.out.println("Digit : "+Digit_Count);
          System.out.println("Vowels : "+Vowels_Count);
          System.out.println("Consonants : "+Consonants_Count);
          System.out.println("Space : "+Space_Count);
    }
}
