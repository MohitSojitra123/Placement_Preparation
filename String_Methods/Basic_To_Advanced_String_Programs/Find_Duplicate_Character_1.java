public class Find_Duplicate_Character_1 {
    public static void main(String[] args) {
        
        String str="a bc efag geba";

        char ch[]=str.toCharArray();
        int count=1;


        for(int i=0; i<ch.length; i++){
            if(ch[i]=='-' || ch[i]==' '){
                continue;
            }else{
                count=1;
                for(int j=i+1; j<ch.length; j++){
                     if(ch[i]==ch[j]){
                        count++;
                         ch[j]='-';
                     }  
                }
                System.out.println(ch[i]+" -> "+count);
            }
        }


    }
}