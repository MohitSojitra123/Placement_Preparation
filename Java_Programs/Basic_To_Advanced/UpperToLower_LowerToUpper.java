import java.util.Scanner;

public class UpperToLower_LowerToUpper {
    public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);

          String str;

          System.out.println("Enter String : ");
          str=sc.nextLine();

          char ch[]=str.toCharArray();

          System.out.println("Str : "+str);

          for(int i=0; i<ch.length; i++){
            if( (ch[i] >= 'A' && ch[i] <= 'Z')  || (ch[i]>='a' && ch[i]<='z')){
                
                  if(ch[i] >= 'A' && ch[i] <= 'Z'){
                    ch[i]=(char)(ch[i]+32);
                  }else{
                    ch[i]=(char)(ch[i]-32);
                  }
            }
          }
          
      String str2=new String(ch);

      System.out.println("Str : "+str2);


          

    }
}
