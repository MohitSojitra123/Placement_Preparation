public class Ransom_Note_Question_383_1 {

    public static void main(String[] args) {

        // Static Input
        String ransomNote = "aa";
        String magazine = "aab";

        int arr[] = new int[26];

        for (int i = 0; i < magazine.length(); i++) {

            char current = magazine.charAt(i);

            arr[current - 'a']++;
        }

        boolean result = true;

        for (int i = 0; i < ransomNote.length(); i++) {

            char current = ransomNote.charAt(i);

            arr[current - 'a']--;

            if (arr[current - 'a'] < 0) {
                result = false;
                break;
            }
        }

        System.out.println("Ransom Note    : " + ransomNote);
        System.out.println("Magazine       : " + magazine);
        System.out.println("Can Construct  : " + result);
    }
}