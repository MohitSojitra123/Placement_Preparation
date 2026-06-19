package Basic_To_Advanced_String_Peograms;
class Convert_Case {

    public static void main(String[] args) {

        String str = "MoHiT";
        String result = "";

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch >= 'A' && ch <= 'Z') {

                ch = (char)(ch + 32);

            }

            else if(ch >= 'a' && ch <= 'z') {
                ch = (char)(ch - 32);
            }


            result = result + ch;
        }

        System.out.println(result);
    }
}