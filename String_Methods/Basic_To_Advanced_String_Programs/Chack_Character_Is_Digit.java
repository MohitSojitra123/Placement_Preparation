package Basic_To_Advanced_String_Peograms;
// Check whether a character is digit or not

public class Chack_Character_Is_Digit {
    public static void main(String[] args) {
        
        char ch='4';

        if(Character.isDigit(ch)){
              System.out.println("Digit : ");
        }else{
            System.out.println("Not Digit : ");
        }

    }
}
