public class Longest_Comman_Prefix_Question_14 {
    public static void main(String[] args) {
        
        String strs[] = {"flower","flow","flight"};
        // String strs[] = {"flower","flow","flight","f"};

        if(strs.length==0){
            System.out.println("String Array Is Empty ! ");
            return ;
        } 


        String Prefix=strs[0];

        for(int i=1; i<strs.length; i++){
             while (strs[i].indexOf(Prefix)!=0) {
                 Prefix=Prefix.substring(0,Prefix.length()-1);
                 if(Prefix.isEmpty()){
                    System.out.println("No Comman Prefix : "); 
                    return;
                 }
             }
        }

        System.out.println("Longest Comman Prefix Is : "+Prefix);

    }
}
