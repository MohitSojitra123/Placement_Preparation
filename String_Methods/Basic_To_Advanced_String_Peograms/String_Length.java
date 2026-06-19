package Basic_To_Advanced_String_Peograms;
class String_Length {

    public static void main(String[] args) {

        String str = "Mohit";


        char ch[] = str.toCharArray();


        int count = 0;


        for(char c : ch) {

            count++;
        }


        System.out.println(count);
    }
}