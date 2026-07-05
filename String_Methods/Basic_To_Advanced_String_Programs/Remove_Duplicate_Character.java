import java.util.Arrays;

public class Remove_Duplicate_Character {
    public static void main(String[] args) {
        
                 String str="abcdef ghi jk abc ghi j j j k a a a ";

                 char str_ch[]=str.toCharArray();

                 System.out.println("123");

                 int size=str_ch.length;

                 for(int i=0; i<size; i++){
                    for(int j=i+1; j<size; j++){
                            if(str_ch[i]==str_ch[j]){
                                  for(int k=j; k<size-1; k++){
                                        str_ch[k]=str_ch[k+1];
                                  }
                                  j--;
                                size--;
                            }
                      }
                 }

         
                 for(int i=0; i<size; i++){
                    System.out.print(str_ch[i]);
                 }
                 
          

    }
}
