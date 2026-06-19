package Basic_To_Advanced_String_Peograms;
import java.util.Arrays;

class String_Each_Word_First_Chracter_Capital {
    public static void main(String[] args) {
        
         String str="java is object orineted programming language";


         String str_arr[]=str.split("\\s");


         for(int i=0; i<str_arr.length; i++){
              String Curent_str=str_arr[i];

            StringBuilder sd=new StringBuilder(Curent_str);

            char ch[]=Curent_str.toCharArray();

            char temp=Character.toUpperCase(ch[0]);

           sd.setCharAt(0, temp);
           
           str_arr[i]=sd.toString();
         }

         System.out.println(Arrays.toString(str_arr));

    }
}