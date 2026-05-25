// Find first Three non-repeated character in string

import java.util.Scanner;

public class  First_Three_Non_Repeating_Character  {
     public static void main(String[] args) {
        
            Scanner sc=new Scanner(System.in);

            System.out.println("Enter Any String To Print Non-Repeated Element....");
            String str=sc.nextLine();

            char[] str1=str.toCharArray();
             int count=0;
             int print_count=0;


            for(int i=0; i<str1.length; i++){
                if(str1[i]=='-'){
                      continue;
                }
                  count=0;
                 if(print_count!=3){
                     for(int j=i+1; j<str1.length; j++){
                         if(str1[i] == str1[j]){
                             count++;
                             str1[j]='-';
                            }
                        }
                    }else{
                         break;
                    }

                  if(count==0){
                      System.out.println("Non Repeated Element => "+str1[i]);
                      print_count++;
                  }
            }
        
     }
}
