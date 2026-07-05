public class Sort_String {
    public static void main(String[] args) {
        
        String str="bacfegdihkj";

        char ch_str[]=str.toCharArray();

        for(int i=0; i<ch_str.length; i++){
            for(int j=0; j<ch_str.length-1-i; j++){
                if(ch_str[j]>ch_str[j+1]){
                   char temp=ch_str[j];
                   ch_str[j]=ch_str[j+1];
                   ch_str[j+1]=temp;
                }
            }
        }

        for(char c:ch_str){
            System.out.print(c);
        }

    }
}
