// Find first repeated character in string

import java.util.Scanner;

public class Find_First_Repeated_Character_In_String {
    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);

         System.out.println("Enter Any Strgin To Find First Repeated Character....");
        String str=sc.nextLine();

        System.out.println("-------------------------------");
        System.out.println(str);
        System.out.println("-------------------------------");

        char[] str1=str.toCharArray();

         int count=0;
         int print_count=0;

         int i,j;

        for( i=0; i<str1.length; i++){
            
             if(str1[i]=='-'){
                  continue;
             }
              if(print_count <=3){
                  for(j=i+1; j<str1.length; j++){
                      if(str1[i] == str1[j]){
                          count++; 
                          str1[j]='-';
                        }
                    }
            }

              if(count>1){
                  System.out.println("Repeted Element => "+str1[i]);
                  print_count++;
                  count=0;
              }
        }

    }
}
