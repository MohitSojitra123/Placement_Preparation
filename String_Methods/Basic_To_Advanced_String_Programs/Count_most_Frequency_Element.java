public class Count_most_Frequency_Element {
    public static void main(String[] args) {
        
        String str="abct gyhj tr evc a bfex a ";

       int count=1,max_count=1;

       char max_char='_';

        char ch_str[]=str.toCharArray();

        for(int i=0; i<str.length(); i++){
            
            if(ch_str[i]==' ' || ch_str[i]=='-'){
                continue;
            }else{   
                count=1;
                for(int j=i+1; j<str.length(); j++){
                      if (ch_str[i]==ch_str[j]) {
                          count++;
                          ch_str[j]='-';
                      }  
                }

                if(count>max_count){
                     max_count=count;
                     max_char=ch_str[i];
                }
            }
        }

        System.out.println("Max Count : "+max_count);
        System.out.println("Max Char : "+max_char);

    }
}
