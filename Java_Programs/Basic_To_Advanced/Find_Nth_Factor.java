import java.util.Scanner;

public class Find_Nth_Factor {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Nth Number Factor : ");
        int nth=sc.nextInt();

        int count=0;

    for(int i=1; ; i++){
        count=0;
         for(int j=1; j<=i; j++){
              if(i%j==0){
                count++;
              }
         }
         if(count==nth){
            System.out.println("Nth Factro Number  : "+i);
            break;
         }
    }



    }
}
