package Basic_To_Advanced_String_Peograms;
// Count number of characters in a string


public class Count_Number_of_Character {
    public static void main(String[] args) {
        
          String str="qwerfdcv4533fg$%^g";

          int count=0;

          for(int i=0; i<str.length(); i++){
              if(Character.isAlphabetic(str.charAt(i))){
                count++;
              }
          }

          System.out.println(count);

    }
}
