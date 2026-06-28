import java.util.HashSet;

public class  Find_Repeated_Character_HashSet{
    public static void main(String[] args) {

        String str = "programming";

        HashSet<Character> set = new HashSet<>();

        for (char ch : str.toCharArray()) {

            if (set.contains(ch)) {
                System.out.println("First Repeated Character: " + ch);
                return;
            }

            set.add(ch);
        }

        System.out.println("No Repeated Character Found");
    }
}