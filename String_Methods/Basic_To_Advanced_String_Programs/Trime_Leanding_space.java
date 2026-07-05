public class Trime_Leanding_space {
    public static void main(String[] args) {
        
        String str = "    Hello World";

int i = 0;

while (i < str.length() && str.charAt(i) == ' ') {
    i++;
}

str = str.substring(i);

System.out.println(str);

    }
}
