public class  Reverse_String_II_Question_541 {

    public static String reverseStr(String s, int k) {

        char[] ch = s.toCharArray();

        for (int i = 0; i < ch.length; i += 2 * k) {

            int left = i;
            int right = Math.min(i + k - 1, ch.length - 1);

            while (left < right) {

                char temp = ch[left];
                ch[left] = ch[right];
                ch[right] = temp;

                left++;
                right--;
            }
        }

        return new String(ch);
    }

    public static void main(String[] args) {

        String s = "abcdefg";   // Static input
        int k = 2;

        String result = reverseStr(s, k);

        System.out.println("Original String : " + s);
        System.out.println("K Value         : " + k);
        System.out.println("Reversed String : " + result);
    }
}