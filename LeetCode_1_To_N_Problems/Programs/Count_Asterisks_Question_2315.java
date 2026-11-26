public class Count_Asterisks_Question_2315 {
    public static void main(String[] args) {

        String s = "l|*e*et|c**o|*de|";

        int count = 0;
        int barCount = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '|') {
                barCount++;
            }

            if (ch == '*' && barCount % 2 == 0) {
                count++;
            }
        }

        System.out.println("Count = " + count);
    }
}