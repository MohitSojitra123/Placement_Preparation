package Basic_To_Advanced_String_Peograms;
public class String_Builder {
    public static void main(String[] args) {
           
        StringBuilder str=new StringBuilder("Mohit ");

        str.append("Patel");

        str.setCharAt(0, 'R');

        str.insert(5, " J ");

        str.delete(6, 7);   // delete(start,end) 

        str.deleteCharAt(4);

        System.out.println(str);

        String temp_str=new String("mohit");
        StringBuilder str_builder=new StringBuilder(temp_str);

        System.out.println(str_builder);


    }
}
