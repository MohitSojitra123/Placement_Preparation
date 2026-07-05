import java.lang.reflect.Array;
import java.util.Arrays;

public class Reverse_Word_in_Array {
    public static void main(String[] args) {

        String str=" i am Mohit Sojitra , Student Of Darashan University";
        
        String[] str_arr=str.split(" ");

        int left=0,right=0;

        for(int i=0; i<str_arr.length; i++){

            if(str_arr[i]==","){
                continue;
            }else{
                            char ch[]=str_arr[i].toCharArray();

            left=0;
            right=ch.length-1;

            while (left<right) {
                char temp=ch[left];
               ch[left]=ch[right];
               ch[right]=temp; 
               left++;
               right--;
            }

            str_arr[i]="";

            for(char c:ch){
                str_arr[i]+=c;
            }

            }

        }

        System.out.println(Arrays.toString(str_arr));

    }
}


// import java.util.Arrays;

// public class ReverseWordInArray {
//     public static void main(String[] args) {

//         String str = "I am Mohit Sojitra, Student Of Darshan University";

//         String[] words = str.split(" ");

//         for (int i = 0; i < words.length; i++) {
//             words[i] = new StringBuilder(words[i]).reverse().toString();
//         }

//         System.out.println(Arrays.toString(words));
//     }
// }