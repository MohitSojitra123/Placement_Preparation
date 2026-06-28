import java.util.Scanner;

public class Reverse_String_All_Word {
   public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);


       System.out.println("Enter String : ");
       String str=sc.nextLine();

       char str_arr[]=str.toCharArray();

       int Starting_Index=0;
       int Ending_Index=0;

       for(int i=0; i<str_arr.length; i++){
           if(str_arr[i]==' '){
            Ending_Index=i-1;     

            while (Starting_Index<Ending_Index) {
                char Temp=str_arr[Starting_Index];
                str_arr[Starting_Index]=str_arr[Ending_Index];
                str_arr[Ending_Index]=Temp;

                Ending_Index--;
                Starting_Index++;
            }
            Starting_Index=i+1;
           }
       }
     
       String reverse_str=new String(str_arr);


       System.out.println(reverse_str);

   }    
}
