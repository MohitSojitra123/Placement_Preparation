public class Consecutive_Duplicate_Character_Compress_String {
    public static void main(String[] args) {
        
          String str="aaabbccccdddddeeffffhi";

          int count=1;

          for(int i=0; i<str.length(); i++){
            
              char current_char=str.charAt(i);
              count=1;

            for(int j=i+1; j<str.length(); j++){
                  if(current_char!=str.charAt(j)){
                    break;
                  }else{
                    count++;
                    i++;
                  }
            }
                
            if(count>1){
                         System.out.print(current_char+""+(count));
            }else{
                System.out.print(current_char);
            }

          }

    }
}
