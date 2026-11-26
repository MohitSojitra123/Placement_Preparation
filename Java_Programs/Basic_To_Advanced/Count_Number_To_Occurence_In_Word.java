import java.util.Scanner;

public class Count_Number_To_Occurence_In_Word {
    public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);
          
          System.out.println("Enter String To Count Number Of Occurence : ");
          String str=sc.nextLine();

          String str_arr[]=str.split("\\s");

          for(int i=0; i<str_arr.length; i++){
                 int count=1;

                 if(str_arr[i]=="--"){
                    continue;
                 }else{
                for(int j=i+1; j<str_arr.length; j++){
                         if(str_arr[i].equals(str_arr[j])){
                             count++;
                             str_arr[j]="--";
                            }
                        }
                    }

                    System.out.println( str_arr[i] + " -> "+count);
                }
    }    
}
