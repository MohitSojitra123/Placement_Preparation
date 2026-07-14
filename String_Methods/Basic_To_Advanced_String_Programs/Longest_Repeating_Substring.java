// Input:
// banana

// Output:
// ana

// Input:
// aabcaabdaab

// Output:
// aab

public class Longest_Repeating_Substring {

    public static void main(String[] args) {

        String str = "banana";

        String longest = "";

        for (int i = 0; i < str.length(); i++) {

            for (int j = i + 1; j <= str.length(); j++) {

                String sub = str.substring(i, j);

                if (str.indexOf(sub) != str.lastIndexOf(sub)) {

                    if (sub.length() > longest.length()) {
                        longest = sub;
                    }
                }
            }
        }

        if (longest.length() > 0)
            System.out.println("Longest Repeating Substring : " + longest);
        else
            System.out.println("No Repeating Substring");
    }
}