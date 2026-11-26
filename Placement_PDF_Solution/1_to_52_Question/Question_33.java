// Take an Input in the form of Binary String that contains only 0’s and 1’s and convert this number into 
// integer.  
// Input: 101.110 
// Output: 5.75

public class Question_33 {

    public static void main(String[] args) {
        String binary = "101.110";

        double result = 0;

        String parts[] = binary.split("\\.");

        String integerPart = parts[0];


        for(int i = 0; i < integerPart.length(); i++){
            char ch = integerPart.charAt(i);
            result = result * 2 + (ch - '0');
        }


        String fractionPart = parts[1];
        double power = 0.5;
        for(int i = 0; i < fractionPart.length(); i++){
            char ch = fractionPart.charAt(i);

            if(ch == '1'){
                result = result + power;
            }
            power = power / 2;
        }

        System.out.println(result);

    }

}