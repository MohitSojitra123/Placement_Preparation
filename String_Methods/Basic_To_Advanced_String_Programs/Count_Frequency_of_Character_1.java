public class Count_Frequency_of_Character_1 {
    public static void main(String[] args) {

        String str="abcdef ghi jk abc ghi j j j k a a a ";

        char str_ch[]=str.toCharArray();

        for(int i=0; i<str_ch.length; i++){
            if(str_ch[i]==' '){
                continue;
            }else if (str_ch[i]=='-') {
                continue; 
            }else{
                  int count=1;
                  for(int j=i+1; j<str.length(); j++){
                       if(str_ch[i]==str_ch[j]){
                            count++;
                            str_ch[j]='-';
                       }
                  }

                  System.out.println(str_ch[i] + " -> " + count);
            }
        }
        
        
        
    }
}
