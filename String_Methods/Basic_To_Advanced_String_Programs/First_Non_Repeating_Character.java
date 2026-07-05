public class First_Non_Repeating_Character {
    
    public static void main(String[] args) {
        

         String str="asghabsgf";

        for(int i=0; i<str.length(); i++){
            
            char Current_Char=str.charAt(i);

            if(str.indexOf(Current_Char)==str.lastIndexOf(Current_Char)){
                 System.out.println("First Non Repeating Character : "+Current_Char); 
                break;
            }

        }
         

    }

}
