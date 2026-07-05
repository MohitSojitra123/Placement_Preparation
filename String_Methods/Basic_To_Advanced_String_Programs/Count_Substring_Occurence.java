public class Count_Substring_Occurence {
    public static void main(String[] args) {
        
        String str="abc dfabc dfr ghtv abcd achb  abtc";

        String[] str_arr=str.split(" ");

        String substr="abc";
        int Same_Number_of_Occurence=0;
        int Contains_Number_of_Occurence=0;
     

        for(int i=0; i<str_arr.length; i++){
              if(str_arr[i].contains(substr)){
                   Contains_Number_of_Occurence++;
              }
              if(str_arr[i].equals(substr)){
                Same_Number_of_Occurence++;
              }
        }

        System.out.println("Same  Occurence : "+Same_Number_of_Occurence);
         System.out.println("Contains Occurence : "+Contains_Number_of_Occurence);


    }
}
