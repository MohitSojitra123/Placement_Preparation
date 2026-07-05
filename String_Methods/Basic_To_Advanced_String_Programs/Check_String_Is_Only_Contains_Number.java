public class Check_String_Is_Only_Contains_Number {
    public static void main(String[] args) {
        
        String str="1 2 3 456 2 34 56a7";

        boolean  flag=true;

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)==' '){
                continue;
            }else{
                if(!(str.charAt(i)>='0' && str.charAt(i)<='9')){
                    flag=false;
                    break;
                }
            }
        }

        if(flag){
            System.out.println("String is only Contains In Number : ");
        }else{
            System.out.println("String Is Not Only Contains is Number ");
        }

    }
}
