public class Check_Contains_Only_Alphabet {
    public static void main(String[] args) {
        
                String str="abcdef ghi jk a   1  bc ghi j j j k a a a ";

                boolean flag=true;

                for(int i=0; i<str.length(); i++){
                    if(str.charAt(i)==' '){
                        continue;
                    }else{
                        if((!(str.charAt(i)>='a' && str.charAt(i)<='z'))){
                            flag=false;
                            break;
                        }
                    }
                }

                if(flag){
                    System.out.println("Only Contains  Alphabet : ");
                }else{
                    System.out.println("Not Containes Only Alphabet : ");
                }

    }
}
