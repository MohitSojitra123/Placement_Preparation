import java.util.Arrays;

public class Capital_First_Letter {
    public static void main(String[] args) {
        
          String str="i am student of darshan univercity : ";

        String[] str_arr=str.split(" ");

        for(int i=0; i<str_arr.length; i++){

             char ch[]=str_arr[i].toCharArray();
             ch[0]=Character.toUpperCase(ch[0]);

             str_arr[i]="";

             for(char c:ch){
                str_arr[i]+=c;
             }
        }
         
        
        System.out.println(Arrays.toString(str_arr));


          

    }
}
