public class IsEmpty_String {
    public static void main(String[] args) {
        
        String str=" ";
        // String str=null;
        // String str="";

        // if(str.isEmpty()){
        //     System.out.println("Empty String : ");
        // }else{
        //     System.out.println("Not Empty String : ");
        // }

        // if(str.length()==0){
        //     System.out.println("String Is Empty : ");
        // }else{
        //     System.out.println("String Is Not Empty : ");
        // }


        // if(str==null){
        //     System.out.println("String Is NULL : ");
        // }else{
        //     System.out.println("String Is Not NULL : ");
        // }

        // if(str.isBlank()){
        //     System.out.println("String Is Blank : ");
        // }else{
        //     System.out.println("String Is Not Blank : ");
        // }

        if(str.trim().isEmpty()){
            System.out.println("String Is Empty : ");
        }else{
            System.out.println("String Is Not Empty : ");
        }


    }
}
