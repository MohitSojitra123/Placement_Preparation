import java.util.Scanner;

public class Remove_Space_From_String {
    public static void main(String[] args) {
        
        String str="dksvn go r t er   tio kt mt t ktrkbn   roikbn m";
        
        System.out.println(str);

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)==' '){
                str=str.substring(0, i)+str.substring(i+1);
                i--;
            }
        }

        System.out.println(str);


    }
}


// StringBuilder sb = new StringBuilder();

// for (int i = 0; i < str.length(); i++) {
//     if (str.charAt(i) != ' ') {
//         sb.append(str.charAt(i));
//     }
// }

// System.out.println(sb.toString());