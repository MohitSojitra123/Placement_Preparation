public class Remove_All_Non_Alphabetic_Character {
    public static void main(String[] args) {
        
        String str="sdf b34v 3456 bvvc543!@#$bgf3$tbv3FVt54";

        System.out.println(str);
        
        for(int i=0; i<str.length(); i++){
            char current_char=str.charAt(i);
            if(!Character.isAlphabetic(current_char)){
                str=str.substring(0, i)+str.substring(i+1);
                i--;
            }
        }

        System.out.println(str);

    }
}
