public class Find_Right_Formate_To_All_SubString_In_any_String  {
    public static void main(String[] args) {
        
           String str="babad";


           for(int i=0; i<str.length(); i++){
            for(int j=i; j<str.length(); j++){
                   String temp=str.substring(i, j+1);
                   System.out.println(temp);
            } 
            System.out.println("\n---------------------------------\n");
           }

    }
}
