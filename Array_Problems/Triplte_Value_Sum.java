// Find triplet with given sum.

// For array [1, 4, 45, 6, 10, 8] and target 22, output will be:
// Triplet found: 4, 10, 8

import java.util.Scanner;

public class Triplte_Value_Sum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int array_size;

    System.out.println("Enter Array Size : ");
    array_size=sc.nextInt();
    
    int array[]=new int[array_size];

    for(int i=0; i<array_size; i++){
            System.out.println("Enter Array Element  :");
            array[i]=sc.nextInt();
    }

    System.out.println("\n------------------------\n");
    for(int i=0; i<array_size; i++){
        System.out.print(array[i]+" ");
    }
    System.out.println("\n------------------------\n");
    
    System.out.println("Enter Sum Value : ");
    int sum=sc.nextInt();
    
    boolean found=false;
    
    for(int i=0; i<array_size-2; i++){
        for(int j=i+1; j<array_size-1; j++){
            for(int k=j+1; k<array_size; k++){
                if(array[i] + array[j] + array[k] == sum){
                    System.out.println("["+array[i] + ","+array[j]+","+array[k]+"]");
                    found=true;
                }
            }
        }
    }
    
    if(!found){
        System.out.println("\n------------------------\n");
        System.out.println("Triplet Sum Is Not Posible : ");
        System.out.println("\n------------------------\n");
    }
    
}
}
