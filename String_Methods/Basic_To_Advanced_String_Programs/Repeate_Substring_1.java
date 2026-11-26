public class Repeate_Substring_1 {
    public static void main(String[] args) {

        // String str = "abccabccabcc";
        String str = "aaa";

        boolean isvalid=true;

        for (int i = 0; i < str.length() / 2; i++) {

            String temp = str.substring(0, i + 1);

            // System.out.println(temp);
            // System.out.println("\n===============\n");

            for (int j = i + 1; j < str.length(); j += temp.length()) {

                  isvalid=true;

                int end = Math.min(j + temp.length(), str.length());

             
                    String Compare=str.substring(j, end);

                    if(Compare.length()==temp.length() && (Compare.equals(temp))){
                     
                    }else{
                            isvalid=false;
                          break;
                    }
            }

            if(isvalid){
                System.out.println("\n++++++++++++++++++++=\n");
                System.out.println(temp);
                System.out.println("\n++++++++++++++++++++=\n");
                break;
            }

            // System.out.println("\n---------------\n");
        }
    }
}