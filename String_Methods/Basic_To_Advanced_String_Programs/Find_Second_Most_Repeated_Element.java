public class Find_Second_Most_Repeated_Element {
    public static void main(String[] args) {
        
        String str="axayrbzbpcqcrdsdtrahajrabl";

        int Max_Count_1=0;
        int Max_Count_2=0;
        
        char Max_Char_1='\0';
        char Max_Char_2='\0';

        char str_ch[]=str.toCharArray();

        int current_count=1;

        for(int i=0; i<str_ch.length; i++){
            if(str_ch[i]=='-'){
                continue;
            }else{

                for(int j=i+1; j<str_ch.length; j++){
                    if(str_ch[i]==str_ch[j]){
                        current_count++;
                        str_ch[j]='-';
                    }
                }

                if(current_count>Max_Count_1){
                    Max_Count_2=Max_Count_1;
                    Max_Char_2=Max_Char_1;

                    Max_Char_1=str_ch[i];
                    Max_Count_1=current_count;
                }else if(current_count>Max_Count_2 && current_count!=Max_Count_1){
                    Max_Char_2=str_ch[i];
                    Max_Count_2=current_count;
                }

                current_count=1;

            }
        }

        System.out.println("Max Count 2 : "+Max_Count_2);
        System.out.println("Max Char 2 : "+Max_Char_2);

    }
}
