import java.util.*;

public class Count_Character_Number_Space_SpecialCharacter {
    public static void main(String[] args) {
    
                      Scanner sc=new Scanner(System.in);

                      int character=0,number=0,special_char=0,space=0;
                      
                      System.out.println("Enter Any String To Count The String Special Characters Like a Digit , letters and Special Character ");
                     String str=sc.nextLine();

                     for(int i=0; i<str.length(); i++){
                           if( (str.charAt(i) >=  65 && str.charAt(i) <= 90)   || (str.charAt(i) >=97 && str.charAt(i)<=122)){
                                character++;
                           }else if(str.charAt(i) >= 48 && str.charAt(i) <= 57){
                              number++;
                           }else if(str.charAt(i) >=33 && str.charAt(i) <= 126){
                            special_char++;
                           }
                           else if(str.charAt(i) == 32){
                              space++;
                           }
                     }

                     System.out.println("Character Is => "+character);
                     System.out.println("Number Is =>"+number);
                     System.out.println("Special Character => "+special_char);
                     System.out.println("Space => "+space);

                    //  Short Way ( <= Predefine Method => )
        //             if (Character.isLetter(ch)) {
        //         letters++;
        //     } else if (Character.isDigit(ch)) {
        //         digits++;
        //     } else if (Character.isWhitespace(ch)) {
        //         spaces++;
        //     } else {
        //         specialChar++;
        //     }
        // }
                    //  Short Way


    }
}
