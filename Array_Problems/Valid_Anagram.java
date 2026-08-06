class Valid_Anagram{
    public static void main(String[] args) {
        
          String s1="mohit";
          String s2="moiht";

          int arr[]=new int[26];

          for(int i=0; i<s1.length(); i++){
              arr[s1.charAt(i)-'a']++;
          }

          for(int i=0; i<s2.length(); i++){
              arr[s2.charAt(i)-'a']--;
          }


          boolean isAnagram=true;

          for(int i=0; i<arr.length; i++){
              if(arr[i]>0){
                 isAnagram=false; 
                 break;
              }
          }

          if(isAnagram){
            System.out.println("s1 and s2 is an Anagram : ");
          }else{
            System.out.println("s1 and s2 is an Not Anagram : ");
          }

    }
}