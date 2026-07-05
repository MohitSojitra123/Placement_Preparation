import java.lang.reflect.Array;
import java.util.Arrays;

public class StringArray_Convert_String {
    public static void main(String[] args) {
        
        String str1="qwe rty tef tr rev hre wrfb htr he g ";
        String str2="qwe,rty,tef,tr,rev,hre,wrfb,htr,he,g";



        String str1_arr[]=str1.split(" ");
        String str2_arr[]=str2.split(",");


        System.out.println(Arrays.toString(str1_arr));

        String str11=String.join(" ",str1_arr);
        System.out.println(str11);

        String str22=String.join(",", str2_arr);
        System.out.println(str22);

        StringBuilder sb2=new StringBuilder();


        for(int i=0; i<str2_arr.length; i++){
               sb2.append(str2_arr[i]);

               if(str2_arr.length-1 != i){
                    sb2.append(",");
               }
        }

        System.out.println(sb2);



        
    }
}
