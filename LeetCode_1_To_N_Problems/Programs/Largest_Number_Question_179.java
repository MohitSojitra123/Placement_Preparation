import java.lang.reflect.Array;
import java.util.Arrays;

class Largest_Number_Question_179 {
    
    public static void main(String[] args) {
        
        
        int array[]={34,14,21,5,13,54,6,2,7,9,8,3};

          
        String str[]=new String[array.length];

        for(int i=0; i<array.length; i++){
            str[i]=array[i]+"";
        }

        Arrays.sort(str,(a1,a2)->(a1+a2).compareTo(a2+a1));

        StringBuilder sb=new StringBuilder("");

        for(int i=str.length-1; i>=0; i--){
              sb.append(str[i]);
        }

        if(sb.charAt(0)=='0'){
            System.out.println("0");
        }else{
            System.out.println(sb.toString());
        }
          

    }

}


