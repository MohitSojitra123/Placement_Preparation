public class Replace_Space_With_UnderScore {
    public static void main(String[] args) {
        
        String str="abc def ghi jkl mno p q r s t";

        System.out.println(str);

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)==' '){
                str=str.substring(0, i)+"_"+str.substring(i+1);
            }

        }

        System.out.println(str);

    }
}
