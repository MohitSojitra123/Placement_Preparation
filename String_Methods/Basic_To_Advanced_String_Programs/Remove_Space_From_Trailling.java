public class Remove_Space_From_Trailling {
    public static void main(String[] args) {
        String str = "Hello World    ";

int i = str.length() - 1;

while (i >= 0 && str.charAt(i) == ' ') {
    i--;
}

str = str.substring(0, i + 1);

System.out.println(str);
    }
}
