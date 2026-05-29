import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Create_Regex{
    public static void main(String[] args) {
        
        String check="aa";

        Pattern patt=Pattern.compile("a+b*");

        Matcher mat=patt.matcher(check);

        boolean verify=mat.matches();

        System.out.println("Result : "+verify);



    }
}