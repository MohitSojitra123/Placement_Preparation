import java.util.Arrays;

public class Replace_Word_In_Syntax {
    public static void main(String[] args) {
        
        String str="abc gf abc rt hf kef g dh g  abc ";

        String Replace_Word="xyz";
        String Find_Word="abc";

        String[] str_arr=str.split(" ");

        for(int i=0; i<str_arr.length; i++){
            if(str_arr[i].equals(Find_Word)){
                   str_arr[i]=Replace_Word;
            }
        }

        String s1=String.join(" ", str_arr);

        System.out.println(s1);



    }
}
