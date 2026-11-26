import java.util.Scanner;

public class Find_Frequency {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int array_size;

        System.out.println("Enter Array Size : ");
        array_size=sc.nextInt();
        
        int array[]=new int[array_size];
        
        for(int i=0; i<array_size; i++){
            System.out.println("Enter Array Element : ");
            array[i]=sc.nextInt();
        }
        
        System.out.println("\n----------------------\n");
        for(int i=0; i<array_size; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println("\n----------------------\n");
        
        
        int visited_array[]=new int[array_size];
        int count=1;
        
        for(int i=0; i<array_size; i++){
            
            if(visited_array[i]==-1){
                continue;
            }else{
                for(int j=i+1; j<array_size; j++){
                    if(array[i]==array[j]){
                         count++;
                         visited_array[j]=-1;
                    }
                }
                System.out.println(array[i] +" ->  "+count);
                count=1;
            }
            
        }
        
        System.out.println("\n----------------------\n");
    }
}
